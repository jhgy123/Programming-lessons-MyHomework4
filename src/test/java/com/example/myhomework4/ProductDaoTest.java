package com.example.myhomework4;

import com.example.myhomework4.dao.IProductDao;
import com.example.myhomework4.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
@SpringBootTest
public class ProductDaoTest {
    @Autowired//需要时自动创建IProductDao对象
    private IProductDao productdao;

    @Test
    public void CreateProduct(){//新增数据记录
        Product p = new Product();
        p.setPid("7777770");
        p.setNum(100L);
        p.setPname("小米手机");
        productdao.save(p);
    }
    @Test
    public void UpdateProduct(){//更新数据记录
        Product p = new Product();
        p.setPid("7777770");
        p.setNum(400L);
        p.setPname("小米手机");
        productdao.save(p);
    }
    @Test
    public void InsetProducts(){//批量新增数据记录
        List<Product> pList=new ArrayList<Product>();
        Product p1 = new Product();
        p1.setPid("7777771");
        p1.setNum(120L);
        p1.setPname("华为手机");

        Product p2 = new Product();
        p2.setPid("7777772");
        p2.setNum(1000L);
        p2.setPname("OPPO手机");

        pList.add(p1);
        pList.add(p2);
        productdao.saveAll(pList);
    }
    @Test
    public void DeleteProduct(){//删除指定的数据记录
        Product p=productdao.findProductByPidAndNum("7777770",400L);
        productdao.delete(p);
    }
    @Test
    public void FindAll(){//查询全部数据记录
        List<Product> pList= productdao.findAll();
        for(Object ob:pList){
            Product product= (Product)ob;
            System.out.println("产品名称："+product.getPname());
        }
    }
    @Test
    public void FindProductsWithId(){
        List<Product> product = productdao.findProductByNumGreaterThan(500L);
        System.out.println("产品名称："+product.get(0).getPname());
    }
}
