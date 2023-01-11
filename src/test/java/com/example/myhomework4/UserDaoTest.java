package com.example.myhomework4;

import com.example.myhomework4.dao.IUserDao;
import com.example.myhomework4.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class UserDaoTest {
    @Autowired//需要时自动创建IUserDao对象
    private IUserDao userdao;

    @Test
    public void CreateUser(){//新增数据记录
        User u = new User();
        u.setId("20202020302");
        u.setName("tom");
        u.setPassword("123456");
        userdao.save(u);
    }

    @Test
    public void UpdateUser(){//更新数据记录
        User u = new User();
        u.setId("20202020302");
        u.setName("TOM");
        u.setPassword("123456");
        userdao.save(u);
    }

    @Test
    public void InsetUsers(){//批量新增数据记录
        List<User> uList=new ArrayList<User>();
        User u1 = new User();
        u1.setId("202001");
        u1.setName("小米");
        u1.setPassword("123456");
        userdao.save(u1);

        User u2 = new User();
        u2.setId("202002");
        u2.setName("小马");
        u2.setPassword("120056");
        userdao.save(u2);

        uList.add(u1);
        uList.add(u2);
        userdao.saveAll(uList);
    }

    @Test
    public void DeleteUser(){//删除指定的数据记录
        User u=userdao.findUserByIdAndPassword("20202020302","123456");
        userdao.delete(u);
    }

    @Test
    public void FindAll(){//查询全部数据记录
        List<User> uList= userdao.findAll();
        for(Object ob:uList){
            User user= (User)ob;
            System.out.println(user.getName());
        }
    }

    @Test
    public void FindUsersWithId(){
        List<User> user = userdao.getUserByIdLagerThan("202001");
        System.out.println(user.get(0).getId());
    }
}
