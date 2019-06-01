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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
/**
 * Description:用户账户
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
@Table(name = SystemConfig.DEFAULT_TABLE_PREFIX + "UsersAccount")
public class UsersAccount implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true, length = 30)
    private String username;//账户
    private String password;//密码
    private String source;//来源
    @Enumerated(EnumType.STRING)
    private StateType stateType;//用户状态
    private Date createDate;//创建时间
    private String explains;//说明

    @ManyToMany
    @JoinTable(name = SystemConfig.SYS_INTERMEDIATE_TABLE_PREFIX + "UsersAccount_Authorities", joinColumns = {@JoinColumn(name = "UsersAccount_ID")}, inverseJoinColumns = {@JoinColumn(name = "Authorities_ID")})
    private Set<Authorities> authorities = new HashSet<Authorities> ();
}
