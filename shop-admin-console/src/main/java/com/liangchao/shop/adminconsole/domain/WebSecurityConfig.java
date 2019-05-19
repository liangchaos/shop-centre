package com.liangchao.shop.adminconsole.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 * Description:创建默认用户
 * User: Administrator-LiangChao
 * Date: 2019-05-19
 * Time: 20:16
 */
@EnableWebSecurity
public class WebSecurityConfig implements WebMvcConfigurer {

    @Bean
    public UserDetailsService userDetailsService () throws Exception {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager ();
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder ();
        manager.createUser (User.withUsername ("admin").password (encoder.encode ("admin")).roles ("administrator").build ());
        return manager;
    }
}
