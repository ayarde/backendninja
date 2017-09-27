package com.udemy.backendninja.service;

import com.udemy.backendninja.entity.Course;

import java.util.List;

public interface CourseService {

    public List<Course> listAllCourses();

    public Course addCourse(Course course);

    public int removeCourse(int id);

    public Course updateCourse(Course course);

    public Course findById(int id);
}
