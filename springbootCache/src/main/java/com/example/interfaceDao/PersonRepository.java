package com.example.interfaceDao;

import com.example.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 查询接口 , 实体类Repository
 * Created by nickzhang on 2016/11/30.
 */
public interface PersonRepository extends JpaRepository<Person,Long> {

}
