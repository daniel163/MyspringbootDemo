package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.example.entity.Person;
import com.example.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by nickzhang on 2016/12/1.
 */
@RestController
public class CacheController {

    @Autowired
    DemoService demoService;


    @RequestMapping("/put")
    public Person put(Person person){
        return demoService.save(person);
    }


    @RequestMapping("/able")
    public Person cacheable(Person person){
        System.out.println("请求参数列表 : " + JSON.toJSONString(person));
        return demoService.findOne(person);
    }

    @RequestMapping("/evit")
    public String evit(Long id){
        demoService.remove(id);
        return "ok";
    }



}
