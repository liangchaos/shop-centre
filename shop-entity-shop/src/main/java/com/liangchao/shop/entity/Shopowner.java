package com.liangchao.shop.entity;

import com.liangchao.shop.SystemConfig;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;
/**
 * Description:店长
 * User: Administrator-LiangChao
 * Date: 2019-05-22
 * Time: 19:31
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = SystemConfig.DEFAULT_TABLE_PREFIX + "Shopowner")
public class Shopowner {

    private Long id;
    private String name;//姓名
    private String sex;//性别
    private String telephone;//座机
    private String phone;//手机
    private String email;//邮箱

}
