package com.udemy.backendninja.service.impl;

import com.udemy.backendninja.entity.Course;
import com.udemy.backendninja.repository.CourseJpaRepository;
import com.udemy.backendninja.service.CourseService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("courseServiceImpl")
public class CourseServiceImpl implements CourseService {

    private static final Log LOGGER = LogFactory.getLog(CourseServiceImpl.class);

    @Autowired
    @Qualifier("courseJpaRepository")
    CourseJpaRepository courseJpaRepository;

    @Override
    public List<Course> listAllCourses() {
        LOGGER.info("Call: " + "listAllCourse()");
        return courseJpaRepository.findAll();
    }

    @Override
    public Course addCourse(Course course) {
        LOGGER.info("Call: " + "addCourse()");
        return courseJpaRepository.save(course);
    }

    @Override
    public int removeCourse(int id) {
       courseJpaRepository.delete(id);
       return 0;
    }

    @Override
    public Course updateCourse(Course course) {
        return courseJpaRepository.save(course);
    }
}
