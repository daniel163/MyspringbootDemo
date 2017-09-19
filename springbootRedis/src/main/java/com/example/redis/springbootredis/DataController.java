package com.example.redis.springbootredis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {

    @Autowired
    PersonDao personDao;


    //演示设置字符及对象
    @RequestMapping("/set")
    public void set(){
        Person person = new Person("1","wyf",32);
        personDao.save(person);
        personDao.stringRedisTemplateDemo();
    }

    //演示获得字符串
    @RequestMapping("/getStr")
    public String getStr(){
        return personDao.getString();
    }

    //演示获得对象
    @RequestMapping("/getPerson")
    public Person getPerson(){
        return personDao.getPerson();
    }
}
