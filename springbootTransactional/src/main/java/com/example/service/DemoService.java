package com.example.service;

import com.example.entity.Person;

/**
 * Created by nickzhang on 2016/12/1.
 */
public interface DemoService {

    public Person savePersonWithRollBack(Person person);

    public Person savePersonWithoutRollBack(Person person);

}
