package com.example.mongodb.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

@RestController
public class DataController {

    @Autowired
    PersonRepository personRepository;


    @RequestMapping("/save")
    public Person save(){
        Person person = new Person("wyf",32);
        Collection<Location> locations = new LinkedHashSet<>();
        Location location1 = new Location("上海","2009");
        Location location2 = new Location("合肥","2010");
        Location location3 = new Location("广州","2011");
        Location location4 = new Location("马鞍山","2012");

        locations.add(location1);
        locations.add(location2);
        locations.add(location3);
        locations.add(location4);

        person.setLocations(locations);
        return personRepository.save(person);
    }

    @RequestMapping("/q1")
    public Person q1(String name){
        //测试方法查询
        return personRepository.findByName(name);
    }

    @RequestMapping("/q2")
    public List<Person> q2(Integer age){
        //测试@Query查询
        return personRepository.withQueryFindByAge(age);
    }

}
