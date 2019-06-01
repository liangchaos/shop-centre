package com.liangchao.shop.webwap.domin.security;

import com.liangchao.shop.webwap.web.Web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.session.SessionManagementFilter;
/**
 * Description: Security 安全框架配置
 * User: Administrator-LiangChao
 * Date: 2019-05-29
 * Time: 20:42
 * <br/>
 * @EnableWebSecurity: 禁用Boot的默认Security配置，配合@Configuration启用自定义配置（需要扩展WebSecurityConfigurerAdapter）
 * @EnableGlobalMethodSecurity(prePostEnabled = true): 启用Security注解，例如最常用的@PreAuthorize
 * configure(HttpSecurity): Request层面的配置，对应XML Configuration中的<http>元素
 * configure(WebSecurity): Web层面的配置，一般用来配置无需安全检查的路径
 * configure(AuthenticationManagerBuilder): 身份验证配置，用于注入自定义身份验证Bean和密码校验规则
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService userDetailsService;
    // @Autowired
    // private DefaultBeforeFilter defaultBeforeFilter;
    // @Autowired
    // private DefaultAfterFilter defaultAfterFilter;

    /** 角色配置 **/
    @Override
    protected void configure (AuthenticationManagerBuilder auth) throws Exception {
        auth
                //实现 userDetailsService 获取用户 角色 权限的实现类
                .userDetailsService (userDetailsService)
                //密码加密解密处理
                .passwordEncoder (new MyPasswordEncoder ());
    }

    /** 过滤资源配置 **/
    @Override
    public void configure (WebSecurity web) throws Exception {
        web.ignoring ().antMatchers ("/files/**", "/js/**", "/css/**", "/images/**", "/**/favicon.ico");
    }

    /** 拦截器配置 **/
    @Override
    protected void configure (HttpSecurity http) throws Exception {
        // @formatter:off
        http.authorizeRequests ()
                //不需要验证请求
                .antMatchers (Web.MAPPLING_WEB_ADMIN_ROOT+"/code").permitAll ()
                //请求需要登录验证
                .anyRequest ().authenticated ()
                //登录
                .and ().formLogin ().loginPage (Web.MAPPLING_WEB_ADMIN_ROOT+"/login")
                                    .failureForwardUrl (Web.MAPPLING_WEB_ADMIN_ROOT+"/login?error")
                                    .usernameParameter ("userName")
                                    .passwordParameter ("passWord")
                                    //.successHandler (new MySuccessHandler())
                                    //.failureHandler (new MyFailureHandler())
                                    .permitAll ()
                                    .defaultSuccessUrl (Web.MAPPLING_WEB_ADMIN_ROOT+"/index",true)
                //登出
                .and ().logout ().logoutUrl (Web.MAPPLING_WEB_ADMIN_ROOT+"/logout")
                                 .logoutSuccessUrl(Web.MAPPLING_WEB_ADMIN_ROOT+"/index")
                                 .invalidateHttpSession(true)
                                 .logoutSuccessHandler(new MyLogoutSuccessHandler ())
                                 .addLogoutHandler(new MyLogoutHandler ())
                                 .deleteCookies("")
        ;
        // @formatter:on

        //添加拦截器 FilterComparator->filterToOrder 中过滤器
        http.addFilterBefore (new DefaultBeforeFilter (), UsernamePasswordAuthenticationFilter.class);
        http.addFilterAfter (new DefaultAfterFilter (), SessionManagementFilter.class);

        //登录拦截器
        http.addFilterBefore (new MyFilterSecurityInterceptor (), FilterSecurityInterceptor.class)
                //springsecurity4自动开启csrf(跨站请求伪造)与restful冲突
                .csrf ().disable ();
    }
}
