package com.nickzhang.Controller;

import com.nickzhang.entity.Info;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by huangqing91 on 2016/11/23.
 */
@RestController
@RequestMapping("/demo")
public class controllerDemo {

    private final static Logger logger = LoggerFactory.getLogger(controllerDemo.class);

    @Autowired
    private Info info;


    @Value("${book.author}")
    private String bookAuthor;

    @Value("${book.name}")
    private String bookName;


    @RequestMapping("/hello")
    public String helloSpringBoot(){
        return "hello spring boot!";
    }

    @RequestMapping("/findValues")
    public String getValues(){
        return "author="+bookAuthor+","+"name="+bookName;
    }

    @RequestMapping("/findValues2")
    public String getValues2(){
        logger.info("logger-request-findValues2");
        return "name="+info.getName()+","+"address="+info.getAddress()+","+"username="+info.getUsername();
    }
}
