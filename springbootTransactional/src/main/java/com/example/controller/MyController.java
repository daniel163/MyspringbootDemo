package com.example.controller;

import com.example.entity.Person;
import com.example.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by nickzhang on 2016/12/1.
 */
@RestController
public class MyController {

    @Autowired
    DemoService demoService;


    @RequestMapping("/rollback")
    public Person rollback(Person person){
        return demoService.savePersonWithRollBack(person);
    }

    @RequestMapping("/norollback")
    public Person norollback(Person person){
        return demoService.savePersonWithoutRollBack(person);
    }

}
