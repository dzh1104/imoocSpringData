package com.imooc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 雇员:  先开发实体类===>自动生成数据表
 */
@Entity
public class Employee {

    private Integer id;

    private String name;

    private Integer age;

    // 自增 auto_increment
    @GeneratedValue
    // primary key
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