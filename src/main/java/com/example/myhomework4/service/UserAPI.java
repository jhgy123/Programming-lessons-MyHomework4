package com.example.myhomework4.service;

import com.example.myhomework4.dao.IUserDao;
import com.example.myhomework4.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController//说明下列服务类型
@Api(tags = "用户管理相关接口")
@RequestMapping("/api/User")//请求映射的根路由
public class UserAPI {

    @Autowired
    private IUserDao userdao;
    @RequestMapping(value = "/login/{id}/{password}", method = RequestMethod.GET)//请求映射的分路由
    @ApiOperation(value = "",tags = "用户登录的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "password", value = "密码", defaultValue = "12345600", required = true),
            @ApiImplicitParam(name = "id", value = "id", defaultValue = "123456", required = true)
    })
    public String login(@PathVariable String id, @PathVariable String password){//路由所对应的方法体
        User u = userdao.findUserByIdAndPassword(id,password);
        if(u==null){
            return "Failed!";
        }
        return u.getName();
    }

    @PostMapping("/login")
    public String loginByIdAndPassword(@RequestParam String id, @RequestParam String password){//路由所对应的方法体
        User u = userdao.findUserByIdAndPassword(id,password);
        if(u==null){
            return "No";
        }
        return u.getName();
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String id, @RequestParam String name, @RequestParam String password){
        User u = new User();
        if(id==null){
            return "Please input id!";
        }
        u.setId(id);
        u.setName(name);
        u.setPassword(password);
        try {
            userdao.save(u);
        }catch(Exception e){return "error"+e.getMessage();}
        return "Register success!";

    }
    @PostMapping("/register2")
    public String registerUser2(@RequestBody User u){
        try {
            userdao.save(u);
        }catch(Exception e){return "error"+e.getMessage();}
        return "Register success!";

    }
    @PutMapping("/update")
    public String update(@RequestBody User u){
        try {
            userdao.save(u);
        }catch(Exception e){return "error"+e.getMessage();}
        return "Update success!";

    }

    @PutMapping("/delete")
    public String delete(@RequestBody String id){
        userdao.deleteById(id);
        return "Delete success!";

    }
}
