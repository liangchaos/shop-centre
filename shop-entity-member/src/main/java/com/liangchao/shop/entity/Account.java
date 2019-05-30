package com.liangchao.shop.entity;

import com.liangchao.shop.SystemConfig;
import com.liangchao.shop.enums.StateType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
/**
 * Description:账户
 * User: Administrator-LiangChao
 * Date: 2019-05-22
 * Time: 19:35
 */
@Setter
@Getter
@ToString
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = SystemConfig.DEFAULT_TABLE_PREFIX + "Account")
public class Account implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true, length = 30)
    private String username;//账户
    private String password;//密码
    private String source;//来源
    private StateType stateType;//用户状态
    private Date createDate;//创建时间
    private String explains;//说明

}
