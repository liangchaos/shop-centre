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
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
/**
 * Description:会员信息管理
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
@Table(name = SystemConfig.DEFAULT_TABLE_PREFIX + "Mmember")
public class Member implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;//姓名
    private String nickname;//昵称
    private String idcard;//身份证号码
    private String phone;//手机
    private String address;//地址
    private String picture;//照片
    private String source;//来源
    private Date createDate;//创建时间
    private String explains;//说明

    @ManyToOne
    @JoinColumn(name = "memberGrade_ID")
    private MemberGrade memberGrade;//会员等级

}
