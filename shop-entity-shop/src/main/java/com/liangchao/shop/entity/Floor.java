package com.liangchao.shop.entity;

import com.liangchao.shop.SystemConfig;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * Description:楼层
 * User: Administrator-LiangChao
 * Date: 2019-05-22
 * Time: 19:25
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = SystemConfig.DEFAULT_TABLE_PREFIX + "Floor")
public class Floor implements Serializable {

    @Id
    @GeneratedValue
    private Long id;//ID
    private String name;//楼层名称
    private String code;//编号
    private String introduce;//介绍
}
