package com.liangchao.shop.service;

import com.liangchao.shop.extend.UserBannerPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Date;
import java.util.Iterator;
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
public class FileServiceApplication {
    private static Logger logger = LoggerFactory.getLogger (FileServiceApplication.class);

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.client.serviceUrl.defaultZone}")
    private String defaultZone;

    public static void main (String[] args) {
        Date startDate = new Date ();

        SpringApplicationBuilder springApp = new SpringApplicationBuilder (FileServiceApplication.class);
        springApp.web (WebApplicationType.SERVLET);
        springApp.run (args);

        // IDEA快速变量的快捷键  CTRL+ALT+V
        logger.info ("<----------------------环境信息--------------------->");
        MutablePropertySources propertySources = springApp.context ().getEnvironment ().getPropertySources ();
        Iterator<PropertySource<?>> iterator = propertySources.iterator ();
        System.out.println (iterator.toString ());

        FileServiceApplication bean = springApp.context ().getBean (FileServiceApplication.class);
        System.out.println (bean.url);
        System.out.println (bean.defaultZone);

        UserBannerPrinter bannerPrinter = new UserBannerPrinter (startDate);
        bannerPrinter.printBanner (springApp.context ().getEnvironment (), FileServiceApplication.class, System.out);

    }

}
