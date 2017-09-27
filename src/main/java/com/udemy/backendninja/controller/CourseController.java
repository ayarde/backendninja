package com.udemy.backendninja.controller;

import com.udemy.backendninja.converter.CourseConverter;
import com.udemy.backendninja.entity.Course;
import com.udemy.backendninja.model.CourseModel;
import com.udemy.backendninja.service.CourseService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/courses")
public class CourseController {

    private static final String COURSE_VIEW = "courses";
    private static final String COURSE_EDIT_VIEW = "edit";

    private static final Log LOGGER = LogFactory.getLog(CourseController.class);

    @Autowired
    @Qualifier("courseServiceImpl")
    private CourseService courseService;

    @GetMapping("/listcourses")
    public ModelAndView listAllCourse() {
        LOGGER.info("Call: " + "listAllCourse()");
        ModelAndView modelAndView = new ModelAndView(COURSE_VIEW);
        modelAndView.addObject("course",new Course());
        modelAndView.addObject("courses",courseService.listAllCourses());
        return modelAndView;
    }

    @PostMapping("/addcourse")
    public String addCourse(@ModelAttribute("course") Course course) {
        LOGGER.info("Call: " + "addCourse()" + " -- Param: " + course.toString());
        courseService.addCourse(course);
        return "redirect:/courses/listcourses";
    }

    @GetMapping("/removecourse/{id}")
    public String removeCourse(@PathVariable("id") int id){
        LOGGER.info("Call: " + "removeCourse()" + "  Course Id " + id);
        courseService.removeCourse(id);
        return "redirect:/courses/listcourses";
    }

    @GetMapping("/editcourse/{id}")
    public ModelAndView editCourse(@PathVariable("id") int id) {
        LOGGER.info("Call: " + "editcourse" + " -- Param: " + id);
        Course course = courseService.findById(id);
        ModelAndView modelAndView = new ModelAndView(COURSE_EDIT_VIEW);
        modelAndView.addObject("course", course);
        return modelAndView;
    }

    @PostMapping("/updatecourse")
    public String updateCourse(@ModelAttribute("course") CourseModel course) {
        LOGGER.info("Call: " + "updateCourse()" + " -- Param: " + course.toString());
        CourseConverter courseConverter = new CourseConverter();

        courseService.updateCourse(courseConverter.modelEntity(course));
        return "redirect:/courses/listcourses";
    }

}
