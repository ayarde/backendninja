package com.udemy.backendninja.converter;

import org.springframework.stereotype.Component;

import com.udemy.backendninja.entity.Course;
import com.udemy.backendninja.model.CourseModel;

@Component("courseConverter")
public class CourseConverter {

    public CourseModel entityModel(Course course){
        CourseModel courseModel = new CourseModel();

        courseModel.setName(course.getName());
        courseModel.setDescription(course.getDescription());
        courseModel.setPrice(course.getPrice());
        courseModel.setHours(course.getHours());

        return courseModel;
    }

    public Course modelEntity(CourseModel courseModel) {
        Course courseEntity = new Course();

        courseEntity.setName(courseModel.getName());
        courseEntity.setDescription(courseModel.getDescription());
        courseEntity.setPrice(courseModel.getPrice());
        courseEntity.setHours(courseModel.getHours());

        return courseEntity;

    }


}
