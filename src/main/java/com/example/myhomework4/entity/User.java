package com.example.myhomework4.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="User_Inf")//重命名表名
public class User {//属性全小写
    @Id//主键标记
    @Column(length = 32)//字段内容最长为32
    private String id;//用户ID信息
    @Column(length = 32)//字段内容最长为32
    private String name;//用户姓名信息
    @Column(length = 32)//字段内容最长为32
    private String password;//用户密码信息
//get和set方法
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
