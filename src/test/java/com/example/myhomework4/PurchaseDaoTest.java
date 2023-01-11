package com.example.myhomework4;

import com.example.myhomework4.dao.IPurchaseDao;
import com.example.myhomework4.entity.Product;
import com.example.myhomework4.entity.Purchase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
@SpringBootTest
public class PurchaseDaoTest {
    @Autowired//需要时自动创建IPurchaseDao对象
    private IPurchaseDao purchasedao;
    @Test
    public void CreatePurchase(){//新增数据记录
        Purchase p = new Purchase();
        p.setPid("7777771");
        p.setUid("202001");
        purchasedao.save(p);
    }
    @Test
    public void UpdatePurchase(){//更新数据记录
        Purchase p = new Purchase();
        p.setId(1);
        p.setPid("7777772");
        p.setUid("202001");
        purchasedao.save(p);
    }
    @Test
    public void InsetPurchases(){//批量新增数据记录
        List<Purchase> pList=new ArrayList<Purchase>();
        Purchase p1 = new Purchase();
        p1.setPid("7777771");
        p1.setUid("202002");

        Purchase p2 = new Purchase();
        p2.setPid("7777772");
        p2.setUid("202002");

        pList.add(p1);
        pList.add(p2);
        purchasedao.saveAll(pList);
    }
    @Test
    public void DeletePurchase(){//删除指定的数据记录
        Purchase p=purchasedao.findPurchaseById(1);
        purchasedao.delete(p);
    }
    @Test
    public void FindAll(){//查询全部数据记录
        List<Purchase> pList= purchasedao.findAll();
        for(Object ob:pList){
            Purchase product= (Purchase)ob;
            System.out.println("购买信息ID号："+product.getId());
        }
    }
    @Test
    public void FindPurchasesWithId(){
        List<Purchase> purchase = purchasedao.getPurchaseByIdLagerThan(5L);
        System.out.println("购买信息ID号："+purchase.get(0).getId());
    }
}
