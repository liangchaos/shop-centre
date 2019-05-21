package com.liangchao.shop.webwap.domin;

import com.liangchao.shop.webwap.web.intercept.UserLoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 * Description:系统拦截器
 * User: Administrator-LiangChao
 * Date: 2019-05-20
 * Time: 22:18
 */
@Configuration
public class SysConfigInterceptor implements WebMvcConfigurer {

    @Override
    public void addInterceptors (InterceptorRegistry registry) {
        registry.addInterceptor (new UserLoginInterceptor ());
    }
}
