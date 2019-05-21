package com.liangchao.shop.webwap.domin;

import com.liangchao.shop.webwap.web.filter.SysConfigRegistry;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * Description:Web 配置
 * User: Administrator-LiangChao
 * Date: 2019-05-20
 * Time: 22:36
 */
@Configuration
public class SysWebConfig {

    @Bean
    public FilterRegistrationBean filterRegistration () {
        //新建过滤器注册类
        FilterRegistrationBean registration = new FilterRegistrationBean();
        // 添加我们写好的过滤器
        registration.setFilter( new SysConfigRegistry());
        // 设置过滤器的URL模式
        registration.addUrlPatterns("/*");
        //设置过滤器顺序
        registration.setOrder(1);
        return registration;
    }

}
