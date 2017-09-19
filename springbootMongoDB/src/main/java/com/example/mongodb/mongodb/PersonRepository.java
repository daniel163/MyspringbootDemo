package com.example.mongodb.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


//数据访问
public interface PersonRepository extends MongoRepository<Person,String>{

    Person findByName(String name);  //支持方法名查询

    @Query("{'age': ?0}")
    List<Person> withQueryFindByAge(Integer age);  //支持@Query查询,查询参数构造JSON字符串

}
