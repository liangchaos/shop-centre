package com.liangchao.shop.configcentre;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
/**
 * Description:Config Server 配置中心
 * User: Administrator-LiangChao
 * Date: 2019-05-19
 * Time: 15:53
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableConfigServer
public class ConfigCentreApplication {

    public static void main (String[] args) {
        SpringApplicationBuilder springApp = new SpringApplicationBuilder (ConfigCentreApplication.class);
        springApp.web (WebApplicationType.SERVLET);
        springApp.run (args);
    }
}
