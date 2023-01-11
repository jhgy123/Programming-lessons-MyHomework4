package com.example.myhomework4.service;
import org.springframework.web.bind.annotation.*;

@RestController//说明下列服务类型
@RequestMapping("/api/Hello")//访问的根路径
public class HelloAPI {
    @RequestMapping(value = "/say/{name}", method = RequestMethod.GET)
    //以get方式响应请求，将路径中的name值显示出来
    public String sayName(@PathVariable String name){
        return name;
    }
    @GetMapping( "/say2/{name}")
    //以get方式响应请求，将路径中的name值显示出来
    public String sayName2(@PathVariable String name){
        return "2"+name;
    }
}
