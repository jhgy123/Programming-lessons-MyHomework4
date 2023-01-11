package com.example.myhomework4.dao;

import com.example.myhomework4.entity.Purchase;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public interface IPurchaseDao extends JpaRepository<Purchase,String> {//继承JpaRepository接口
    Purchase findPurchaseById(long id);//通过id属性来查找Purchase对象
    List<Purchase> findPurchaseByIdGreaterThan(String id) ;//查找Id大于某一要求的Purchase对象列表

    @Modifying
    @Transactional
    @Query("update Purchase p set p.uid=:uid where p.id=:id")//JPQL语句 根据id更新Purchase的pid
    int updatePurchaseNameById(@Param("uid") String userid, @Param("id") String id);
    //定义方法，并且向JPQL语句中传递参数，执行JPQL语句

    @Query("select p from Purchase p where p.id=:id")//JPQL语句 JPQL语句 根据id查找Purchase对象
    List<Purchase> getPurchaseByIdLagerThan(@Param("id") long id);
    //定义方法，并且向JPQL语句中传递参数，执行JPQL语句
}