/*
package com.example.specs;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.Attribute;
import javax.persistence.metamodel.EntityType;
import java.util.ArrayList;
import java.util.List;

*/
/**
 * 自动模糊查询
 * Created by nickzhang on 2016/11/30.
 *//*

public class CustomerSpecs {

    public static <T> Specification<T> byAuto(final EntityManager entityManager,final T example){

        */
/*获取当前实体类的类对象类型*//*

        final Class<T> type = (Class<T>) example.getClass();

        return new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                */
/*存储构造的查询条件(Predicate函数式接口,判断输入的对象是否符合某条件)*//*

                List<Predicate> predicates = new ArrayList<>();

                */
/*获得实体类的EntityType,通过这个可以获得实体类的属性*//*

                EntityType<T> entity = entityManager.getMetamodel().entity(type);s

                */
/*对实体类的所有属性做循环*//*

                for (Attribute<T,?> attr : entity.getDeclaredAttributes()){

                }


                return null;
            }
        }
    }

}
*/
