package com.liangchao.shop.webwap;

import com.liangchao.shop.extend.UserBannerPrinter;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.Date;
/**
 * Description:
 * User: Administrator-LiangChao
 * Date: 2019-05-20
 * Time: 9:54
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
//豪猪监控平台
@EnableCircuitBreaker
public class WebWapApplication {

    public static void main (String[] args) {
        Date startDate = new Date ();

        SpringApplicationBuilder springApp = new SpringApplicationBuilder (WebWapApplication.class);
        springApp.web (WebApplicationType.SERVLET);
        springApp.run (args);

        UserBannerPrinter bannerPrinter = new UserBannerPrinter (startDate);
        bannerPrinter.printBanner (springApp.context ().getEnvironment (), WebWapApplication.class, System.out);

    }
}
