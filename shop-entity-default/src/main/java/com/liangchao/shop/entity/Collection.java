package com.liangchao.shop.entity;

import com.liangchao.shop.SystemConfig;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
/**
 * Description:链接收藏管理
 * User: Administrator-LiangChao
 * Date: 2019-05-22
 * Time: 19:35
 */
@Setter
@Getter
@ToString
//链式编程
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = SystemConfig.DEFAULT_TABLE_PREFIX + "Collection")
public class Collection implements Serializable{

    @Id
    @GeneratedValue
    private Long id;
    private String name;//名称
    private String type;//类型
    private String path;//路径
    private String source;//来源
    private String userSource;//来源用户
    private Date createDate;//创建时间

}
