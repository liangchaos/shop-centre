package com.liangchao.shop.configcentre;

import com.liangchao.shop.extend.UserBannerPrinter;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.Date;
/**
 * Description:Config Server Service配置中心
 * User: Administrator-LiangChao
 * Date: 2019-05-19
 * Time: 15:53
 * <Br>
 * /{application}/{profile}[/{label}]
 * /{application}-{profile}.yml
 * /{label}/{application}-{profile}.yml
 * /{application}-{profile}.properties
 * /{label}/{application}-{profile}.properties
 * <Br>
 * 注：config 客户端在没有 spring.cloud.config.name属性的时候，服务端{application} 获取的是客户端
 * spring.application.name的值，否则，获取的是 spring.cloud.config.name的值。
 * 1）、当没有spring.cloud.config.name时，客户端获取的是spring.application.name 所对应的git库中的文件，并且只能
 * 获取一个文件，
 * 2）、当一个项目中有需求要获取多个文件时，就需要用到spring.cloud.config.name这个属性，以逗号分割
 * <Br>
 * org.springframework.cloud.config.server.support.AbstractScmAccessor在这个类中有getSearchLocations这个方法
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableConfigServer
public class ConfigCentreServiceApplication {

    public static void main (String[] args) {
        Date startDate = new Date ();

        SpringApplicationBuilder springApp = new SpringApplicationBuilder (ConfigCentreServiceApplication.class);
        springApp.web (WebApplicationType.SERVLET);
        springApp.run (args);

        UserBannerPrinter bannerPrinter = new UserBannerPrinter (startDate);
        bannerPrinter.printBanner (springApp.context ().getEnvironment (), ConfigCentreServiceApplication.class, System.out);

    }
}
