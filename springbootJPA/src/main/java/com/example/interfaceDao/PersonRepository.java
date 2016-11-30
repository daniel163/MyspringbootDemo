package com.example.interfaceDao;

import com.example.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 查询接口
 * Created by nickzhang on 2016/11/30.
 */
public interface PersonRepository extends JpaRepository<Person,Long> {

    List<Person> findByAddress(String name);

    Person findByNameAndAddress(String name,String address);

    /*使用query查询,参数按照名称绑定*/
    @Query("select p from Person p where p.name= :name and p.address= :address")
    Person withNameAndAddressQuery(@Param("name") String name,@Param("address") String address);

    /*使用NamedQuery查询*/
    Person withNameAndAddressNamedQuery(String name,String address);

}
