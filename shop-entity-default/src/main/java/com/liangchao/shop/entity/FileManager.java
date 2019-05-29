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
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
/**
 * Description:文件管理
 * User: Administrator-LiangChao
 * Date: 2019-05-22
 * Time: 19:35
 * <Br>
 * 常用注解
 * @Data 注解在类上；提供类所有属性的 getting 和 setting 方法，此外还提供了equals、canEqual、hashCode、toString 方法
 * @Setter ：注解在属性上；为属性提供 setting 方法
 * @Setter ：注解在属性上；为属性提供 getting 方法
 * @Log4j ：注解在类上；为类提供一个 属性名为log 的 log4j 日志对象
 * @NoArgsConstructor ：注解在类上；为类提供一个无参的构造方法
 * @AllArgsConstructor ：注解在类上；为类提供一个全参的构造方法
 * @Cleanup : 可以关闭流
 * @Builder ： 被注解的类加个构造者模式
 * @Synchronized ： 加个同步锁
 * @SneakyThrows : 等同于try/catch 捕获异常
 * @NonNull : 如果给参数加个这个注解 参数为null会抛出空指针异常
 * @Value : 注解和@Data类似，区别在于它会把所有成员变量默认定义为private final修饰，并且不会生成set方法。
 */
@Setter
@Getter
@ToString
//链式编程
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = SystemConfig.DEFAULT_TABLE_PREFIX + "FileManager")
public class FileManager implements Serializable{

    @Id
    @GeneratedValue
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
