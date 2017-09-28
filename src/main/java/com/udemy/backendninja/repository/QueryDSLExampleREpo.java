package com.udemy.backendninja.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.udemy.backendninja.entity.Course;
import com.udemy.backendninja.entity.QCourse;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.querydsl.core.types.Predicate;

@Repository("queryDSLExampleRepo")
public class QueryDSLExampleREpo {

   private QCourse qCourse = QCourse.course;

    @PersistenceContext
    private EntityManager em;

    public Course find(boolean exist){
        JPAQuery<Course> query = new JPAQuery<Course>(em);

        BooleanBuilder predicateBuilder = new BooleanBuilder(qCourse.description.endsWith("OP"));

        if(exist){
            Predicate predicate2 = qCourse.id.eq(23);
            predicateBuilder.and(predicate2);
        }else{
            Predicate predicate3 = qCourse.name.endsWith("OP");
            predicateBuilder.or(predicate3);
        }
        return query.select(qCourse).from(qCourse).where(predicateBuilder).fetchOne();

    }
}
