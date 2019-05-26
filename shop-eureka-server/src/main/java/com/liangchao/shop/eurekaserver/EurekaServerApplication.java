package com.liangchao.shop.eurekaserver;

import com.liangchao.shop.extend.UserBannerPrinter;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import java.util.Date;
/**
 * Description:服务治理
 * User: Administrator-LiangChao
 * Date: 2019-05-19
 * Time: 15:53
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

    public static void main (String[] args) {
        Date startDate = new Date ();

        SpringApplicationBuilder springApp = new SpringApplicationBuilder (EurekaServerApplication.class);
        springApp.web (WebApplicationType.SERVLET);
        springApp.run (args);

        UserBannerPrinter bannerPrinter = new UserBannerPrinter (startDate);
        bannerPrinter.printBanner (springApp.context ().getEnvironment (), EurekaServerApplication.class, System.out);
    }
}
