package com.example.myhomework4.dao;

import com.example.myhomework4.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public interface IUserDao extends JpaRepository<User,String> {//继承JpaRepository接口
    User findUserByIdAndPassword(String id, String password);//通过Id和Password两个属性来查找User对象
    List<User> findUserByIdGreaterThan(String id) ;//查找Id大于某一要求的User对象列表

    @Modifying
    @Transactional
    @Query("update User u set u.name=:name where u.id=:id")//JPQL语句 根据id更新User的姓名
    int updateUserNameById(@Param("id") String userid, @Param("name") String username);
    //定义方法，并且向JPQL语句中传递参数，执行JPQL语句

    @Query("select u from User u where u.id=:id")//JPQL语句 JPQL语句 根据id查找User对象
    List<User> getUserByIdLagerThan(@Param("id") String id) ;
    //定义方法，并且向JPQL语句中传递参数，执行JPQL语句
}
