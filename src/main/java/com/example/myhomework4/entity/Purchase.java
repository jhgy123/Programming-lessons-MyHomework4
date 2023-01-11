package com.example.myhomework4.entity;

import javax.persistence.*;

@Entity
@Table(name="Purchase_Inf")//重命名表名
public class Purchase {//属性全小写
    @Id//主键标记
    @Column(length = 32)//字段内容最长为32
    @GeneratedValue(strategy = GenerationType.IDENTITY)//id值自动增加
    private long id;//购买记录ID编号
    @Column(length = 32)//字段内容最长为32
    private String uid;//购买用户id信息
    @Column(length = 32)//字段内容最长为32
    private String pid;//购买产品id信息
//get和set方法

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}