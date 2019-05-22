package com.liangchao.shop.configclient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
/**
 * Description:
 * User: Administrator-LiangChao
 * Date: 2019-05-16
 * Time: 18:35
 */
@Component
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ShopInfo {

    /***************************************************************
     * @Value的值有两类：
     * ① ${ property : default_value }
     * ② #{ obj.property? : default_value }
     * 就是说，第一个注入的是外部参数对应的property，第二个则是SpEL表达式对应的内容。
     * 那个 default_value，就是前面的值为空时的默认值。注意二者的不同。
     *
     *@@方式常用于引用springboot非默认配置文件（即其他配置文件）中的变量，
     * 是springboot为替代${}属性占位符产生，原因是${}会被maven处理，所以引用非默认配置文件时起不到引用变量的作用。
     * 语法为：field_name=@field_value@
     ****** ************************************************ */

    @Value("${info.app.name}")
    private String name;
    //@Value("${info.app.url}")
    //private String url;
    @Value("${info.app.port}")
    private String port;
    @Value("${info.app.href}")
    private String href;
}
