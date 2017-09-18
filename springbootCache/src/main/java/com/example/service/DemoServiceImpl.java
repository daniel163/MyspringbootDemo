package com.example.service;

import com.alibaba.fastjson.JSON;
import com.example.entity.Person;
import com.example.interfaceDao.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by nickzhang on 2016/12/1.
 */
@Service
public class DemoServiceImpl implements DemoService{

    @Autowired
    PersonRepository personRepository;

    @Override
    @CachePut(value = "people",key = "#person.id")  /*@CachePut缓存新增的或更新的数据到缓存,缓存名称为people,数据的key是person的id*/
    public Person save(Person person) {
        Person p = personRepository.save(person);
        System.out.println("为"+JSON.toJSONString(p) + "做了缓存..");
        return p;
    }

    @Override
    @CacheEvict(value = "people") /*从缓存people中删除key为id的数据*/
    public void remove(Long id) {
        personRepository.delete(id);
    }

    @Override
    @Cacheable(value = "people",key = "#person.id")  /*@Cacheable缓存key为person的id数据到缓存people中*/
    public Person findOne(Person person) {
        Person p = personRepository.findOne(person.getId());
        System.out.println("缓存数据 : " + JSON.toJSONString(p));
        return p;
    }
}
