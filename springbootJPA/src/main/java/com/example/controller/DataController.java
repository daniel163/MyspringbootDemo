package com.example.controller;

import com.example.entity.Person;
import com.example.interfaceDao.PersonRepository;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by nickzhang on 2016/11/30.
 */
@RestController
public class DataController {

    @Autowired
    PersonRepository personRepository;


    @RequestMapping("/save")
    public Person save(String name,String address,Integer age){
        Person person = personRepository.save(new Person(name,age,address));
        return person;
    }


    @RequestMapping("/findByAddress")
    public List<Person> findByAddress(String address){
        List<Person> people = personRepository.findByAddress(address);
        return people;
    }

    @RequestMapping("/findByNameAndAddress")
    public Person findByNameAndAddress(String name,String address){
        Person person = personRepository.findByNameAndAddress(name,address);
        return person;
    }


    @RequestMapping("/withNameAndAddressQuery")
    public Person withNameAndAddressQuery(String name,String address){
        Person person = personRepository.withNameAndAddressQuery(name,address);
        return person;
    }


    @RequestMapping("/withNameAndAddressNamedQuery")
    public Person withNameAndAddressNamedQuery(String name,String address){
        Person person = personRepository.withNameAndAddressNamedQuery(name,address);
        return person;
    }


    /*测试排序*/
    @RequestMapping("/sort")
    public List<Person> sort(){
        List<Person> persons = personRepository.findAll(new Sort(Sort.Direction.ASC,"age"));
        return persons;
    }


    /*测试分页*/
    @RequestMapping("/page")
    public Page<Person> page(){
        Page<Person> personPage = personRepository.findAll(new PageRequest(1,2));
        return personPage;
    }

}
