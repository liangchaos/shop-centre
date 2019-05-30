package com.liangchao.shop.webwap.domin;

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
                .and ().formLogin ().loginPage ("/login").permitAll ().defaultSuccessUrl ("/index",true)
                .and ().logout ().logoutUrl ("/logout")
        ;
        // @formatter:on
    }
}
