package com.imooc.domain;

import javax.persistence.*;

// JPA教程: http://www.cnblogs.com/crawl/p/7703679.html

/**
 * 雇员:  先开发实体类===>自动生成数据表
 */

// 使用注释 @Entity 创建实体类
// 指明该类将映射到指定的数据表，Employee 类默认的数据表名为 employee
// 当实体类与映射的数据库表名不同名时需要使用 @Table 注解，该注解与 @Entity 注解并列使用，使用其 name 属性指明数据库的表名
@Table(name = "employee")
@Entity
public class Employee {

    private Integer id;

    private String name;

    private Integer age;

    // 自增 auto_increment
    @GeneratedValue
    // primary key
    // 标识该属性为主键，一般标注在该属性的 getter 方法上
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // 长度 varchar(20)
    @Column(length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}