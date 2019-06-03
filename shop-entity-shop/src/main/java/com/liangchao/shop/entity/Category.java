package com.liangchao.shop.entity;

import com.liangchao.shop.SystemConfig;
import com.liangchao.shop.enums.TypeState;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * Description:品类
 * User: Administrator-LiangChao
 * Date: 2019-05-22
 * Time: 19:24
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = SystemConfig.DEFAULT_TABLE_PREFIX + "Category")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//ID
    private String name;//品类名称
    @Enumerated(EnumType.STRING)
    private TypeState typeState;//状态
}
