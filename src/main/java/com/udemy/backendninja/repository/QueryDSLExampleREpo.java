package com.udemy.backendninja.repository;

import com.querydsl.jpa.impl.JPAQuery;
import com.udemy.backendninja.entity.Course;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository("queryDSLExampleRepo")
public class QueryDSLExampleREpo {

   // private QCourse qCourse = QCourse.course;

    @PersistenceContext
    private EntityManager em;

    public void find(){
        JPAQuery<Course> query = new JPAQuery<Course>(em);
        //Course course = query.select(qCourse).from(qCourse).where(qCourse.id.eq(23)).fetchOne();
    }
}
