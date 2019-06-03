package com.liangchao.shop.entity;

import com.liangchao.shop.SystemConfig;
import com.liangchao.shop.enums.TypeState;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * Description:会员等级
 * User: Administrator-LiangChao
 * Date: 2019-05-29
 * Time: 11:13
 */
@Setter
@Getter
@ToString
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = SystemConfig.DEFAULT_TABLE_PREFIX + "MemberGrade")
public class MemberGrade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;//积分名称
    private Long integral;//积分
    private TypeState typeState;//状态
    private String explains;//说明
    
}
