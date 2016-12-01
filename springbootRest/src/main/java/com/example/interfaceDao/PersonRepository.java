package com.example.interfaceDao;

import com.example.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * 查询接口
 * Created by nickzhang on 2016/11/30.
 */
@RepositoryRestResource(path = "people") /*自定义路径,默认是实体类名后加s ,例如本例就是 persons*/
public interface PersonRepository extends JpaRepository<Person,Long> {

    /*http://localhost:8080/persons/search/nameStartsWith?name=nickzhang1*/
    @RestResource(path = "nameStartsWith",rel = "nameStartsWith") /*配置为rest资源*/
    Person findByNameStartsWith(@Param("name") String name);

}
