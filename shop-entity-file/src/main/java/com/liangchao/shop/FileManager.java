package com.liangchao.shop;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
/**
 * Description:文件管理
 * User: Administrator-LiangChao
 * Date: 2019-05-22
 * Time: 19:35
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = SystemConfig.DEFAULT_TABLE_PREFIX + "FileManager")
public class FileManager {

    private Long id;
    private String name;//名称
    private String type;//类型
    private Long size;//文件大小
    private String path;//路径
    private String source;//来源
    private Date createDate;//创建时间
    private Boolean identifying;//标识 true为临时文件
    private String userSource;//来源用户
    
}
