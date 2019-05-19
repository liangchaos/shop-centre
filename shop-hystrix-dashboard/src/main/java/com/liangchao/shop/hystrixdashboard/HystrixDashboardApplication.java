package com.liangchao.shop.hystrixdashboard;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
/**
 * Description:豪猪监控
 * User: Administrator-LiangChao
 * Date: 2019-05-19
 * Time: 15:53
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableHystrixDashboard
public class HystrixDashboardApplication {

    public static void main (String[] args) {
        SpringApplicationBuilder springApp = new SpringApplicationBuilder (HystrixDashboardApplication.class);
        springApp.web (WebApplicationType.SERVLET);
        springApp.run (args);
    }
}
