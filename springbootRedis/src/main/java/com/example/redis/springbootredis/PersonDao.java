package com.example.redis.springbootredis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;

@Repository
public class PersonDao {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    //可以使用@Resource注解指定stringRedisTemplate,可注入给予字符串的简单属性操作方法
    @Resource(name = "stringRedisTemplate")
    ValueOperations<String,String> valOpsStr;

    @Autowired
    RedisTemplate<String,String> redisTemplate;

    @Resource(name = "redisTemplate")
    ValueOperations<Object,Object> valOps;


    //通过set方法存储字符串类型
    public void stringRedisTemplateDemo(){
        valOpsStr.set("XX","YY");
    }

    //存储对象类型
    public void save(Person person){
        valOps.set(person.getId(),person);
    }

    public String getString(){
        return valOpsStr.get("XX");
    }

    public Person getPerson(){
        return (Person) valOps.get("1");
    }

}
