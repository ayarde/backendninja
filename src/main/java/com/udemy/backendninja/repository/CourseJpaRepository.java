package com.udemy.backendninja.repository;

import com.udemy.backendninja.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("courseJpaRepository")
public interface CourseJpaRepository extends JpaRepository<Course,Serializable>{

}
