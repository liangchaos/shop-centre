package com.liangchao.shop.entity;

import com.liangchao.shop.SystemConfig;
import com.liangchao.shop.enums.StateType;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
/**
 * Description:授权 角色
 * User: Administrator-LiangChao
 * Date: 2019-05-31
 * Time: 13:29
 */
@Data
@Accessors(chain = true)
@Entity
@Table(name = SystemConfig.DEFAULT_TABLE_PREFIX + "Authorities")
public class Authorities implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, length = 30)
    private String auth;//角色
    private String name;//角色中文名称
    private StateType stateType;//用户状态
    private String explains;//说明

    @ManyToMany
    @JoinTable(name = SystemConfig.SYS_INTERMEDIATE_TABLE_PREFIX + "UsersAccount_Authorities", joinColumns = {@JoinColumn(name = "Authorities_ID")}, inverseJoinColumns = {@JoinColumn(name = "UsersAccount_ID")})
    private Set<UsersAccount> usersAccounts = new HashSet<UsersAccount> ();

    @ManyToMany
    @JoinTable(name = SystemConfig.SYS_INTERMEDIATE_TABLE_PREFIX + "Permission_Authorities", joinColumns = {@JoinColumn(name = "Authorities_ID")}, inverseJoinColumns = {@JoinColumn(name = "Permission_ID")})
    private Set<Permission> permissions=new HashSet<Permission> ();
}
