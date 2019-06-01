package com.liangchao.shop.service;

import com.liangchao.shop.extend.UserBannerPrinter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Date;
/**
 * Description:系统配置
 * User: Administrator-LiangChao
 * Date: 2019-05-22
 * Time: 19:35
 */
@SpringBootApplication
@EnableCircuitBreaker
@EnableDiscoveryClient
@EnableEurekaClient
//@EnableJpaRepositories(basePackages={"dao层对应的包路径"})
@EnableJpaRepositories(basePackages = {"com.liangchao.shop.service.repository"})
//@EntityScan("entity对应的包路径")
@EntityScan(basePackages = {"com.liangchao.shop.entity"})
public class MemberServiceApplication {

    public static void main (String[] args) {
        Date startDate = new Date ();

        SpringApplicationBuilder springApp = new SpringApplicationBuilder (MemberServiceApplication.class);
        springApp.web (WebApplicationType.SERVLET);
        springApp.run (args);

        UserBannerPrinter bannerPrinter = new UserBannerPrinter (startDate);
        bannerPrinter.printBanner (springApp.context ().getEnvironment (), MemberServiceApplication.class, System.out);

    }

}
