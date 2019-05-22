package com.liangchao.shop.entity;

import com.liangchao.shop.FileManager;
import com.liangchao.shop.SystemConfig;
import com.liangchao.shop.enums.ShopType;
import com.liangchao.shop.enums.StateType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.io.Serializable;
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
@Entity
@Table(name = SystemConfig.DEFAULT_TABLE_PREFIX + "Shop")
public class Shop implements Serializable {

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

    private List<FileManager> picture;//图片
    private Shopowner shopowner;//店长 掌柜
    private Category category;//品类
    private Floor floor;//楼层

}
