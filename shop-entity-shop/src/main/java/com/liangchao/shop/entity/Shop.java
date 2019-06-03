package com.liangchao.shop.entity;

import com.liangchao.shop.SystemConfig;
import com.liangchao.shop.enums.ShopType;
import com.liangchao.shop.enums.StateType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * Description:商户
 * User: Administrator-LiangChao
 * Date: 2019-05-20
 * Time: 9:54
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = SystemConfig.DEFAULT_TABLE_PREFIX + "Shop")
public class Shop implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//ID
    private String name;//商户名称
    @Enumerated(EnumType.STRING)
    private StateType stateType;//商户状态
    @Enumerated(EnumType.STRING)
    private ShopType shopType;//商户类型
    private Date startDate;//开业时间
    private Date entDate;//关闭时间
    private Float score;//评分
    private Integer area;//面积
    private String address;//地址
    private String introduce;//介绍
    private String logo;//logo

    @ManyToMany
    @JoinTable(name = SystemConfig.SYS_INTERMEDIATE_TABLE_PREFIX + "SHOP_FILEMANAGER", joinColumns = {@JoinColumn(name = "SHOP_ID")}, inverseJoinColumns = {@JoinColumn(name = "FILEMANAGER_ID")})
    private List<FileManager> fileManager = new ArrayList<FileManager> ();//图片
    private Shopowner shopowner;//店长 掌柜
    private Category category;//品类
    private Floor floor;//楼层

}
