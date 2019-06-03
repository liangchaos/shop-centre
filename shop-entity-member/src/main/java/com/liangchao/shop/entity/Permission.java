package com.liangchao.shop.entity;

import com.liangchao.shop.SystemConfig;
import com.liangchao.shop.enums.StateType;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
/**
 * Description:授权 角色权限
 * User: Administrator-LiangChao
 * Date: 2019-05-31
 * Time: 13:29
 */
@Data
@Accessors(chain = true)
@Entity
@Table(name = SystemConfig.DEFAULT_TABLE_PREFIX + "Permission")
public class Permission implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, length = 30)
    private String path;//权限路径
    private String pathKey;//权限key 用于注解
    private StateType stateType;//状态
    private String explains;//说明

    /** 父节点 **/
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "parent_Id")
    private Permission parent;
    /** 子节点 **/
    @OneToMany(mappedBy = "parent", cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Set<Permission> children = new HashSet<Permission> ();
}
