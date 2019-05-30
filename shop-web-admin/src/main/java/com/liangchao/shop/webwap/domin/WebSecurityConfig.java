package com.liangchao.shop.webwap.domin;

import com.liangchao.shop.webwap.web.Web;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
/**
 * Description: Security 安全框架配置
 * User: Administrator-LiangChao
 * Date: 2019-05-29
 * Time: 20:42
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /** 角色配置 **/
    @Override
    protected void configure (AuthenticationManagerBuilder auth) throws Exception {
        super.configure (auth);
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
                .and ().formLogin ().loginPage (Web.MAPPLING_WEB_ADMIN_ROOT+"/login").permitAll ().defaultSuccessUrl (Web.MAPPLING_WEB_ADMIN_ROOT+"/index",true)
                //登出
                .and ().logout ().logoutUrl (Web.MAPPLING_WEB_ADMIN_ROOT+"/logout")
        ;
        // @formatter:on
    }
}
