package com.example.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.entity.Person;
import com.example.interfaceDao.PersonRepository;
import com.example.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by nickzhang on 2016/12/1.
 */
@Service
public class DemoServiceimpl implements DemoService{

    @Autowired
    PersonRepository personRepository;

    @Transactional(rollbackFor = {IllegalArgumentException.class})  /*指定特定的异常使数据回滚*/
    @Override
    public Person savePersonWithRollBack(Person person) {
        Person p = personRepository.save(person);
        System.out.println("person = " + JSON.toJSONString(p));
        if (p.getName().equals("nickzhangTran")){
            throw new IllegalArgumentException("数据已经存在,回滚!");
        }

        return p;
    }

    @Transactional(noRollbackFor = {IllegalArgumentException.class})
    @Override
    public Person savePersonWithoutRollBack(Person person) {
        Person p = personRepository.save(person);

        if (p.getName().equals("nickzhangTran")){
            throw new IllegalArgumentException("数据已经存在,但不回滚,继续执行!");
        }

        return p;
    }

}
