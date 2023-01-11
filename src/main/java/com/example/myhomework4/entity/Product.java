package com.example.myhomework4.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Product_Inf")//重命名表名
public class Product {//属性全小写
    @Id//主键标记
    @Column(length = 32)//字段内容最长为32
    private String pid;//产品ID信息
    @Column(length = 32)//字段内容最长为32
    private String pname;//产品名字信息
    @Column(length = 32)//字段内容最长为32
    private long num;//产品数量信息
//get和set方法

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public long getNum() {
        return num;
    }

    public void setNum(long num) {
        this.num = num;
    }
}