package com.example.myhomework4.dao;

import com.example.myhomework4.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public interface IProductDao extends JpaRepository<Product,String> {//继承JpaRepository接口
    Product findProductByPidAndNum(String pid,long num);//通过pid和num两个属性来查找Product对象
    List<Product> findProductByNumGreaterThan(long num) ;//查找num大于某一要求的Product对象列表

    @Modifying
    @Transactional
    @Query("update Product p set p.num=:num where p.pid=:pid")//JPQL语句 根据pid更新Product的num属性
    int updateProductNumByPid(@Param("num") long pronum, @Param("pid") String pid);
    //定义方法，并且向JPQL语句中传递参数，执行JPQL语句
    @Query("select p from Product p where p.num=:num")//JPQL语句 JPQL语句 根据num查找Product对象
    List<Product> getProductByNumLagerThan(@Param("num") long num);
    //定义方法，并且向JPQL语句中传递参数，执行JPQL语句
}