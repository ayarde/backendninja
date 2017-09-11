package com.udemy.backendninja.controller;

import com.udemy.backendninja.service.ExerciseService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/exercise")
public class ExerciseController {

    public static final Log LOGGER = LogFactory.getLog(ExerciseController.class);

    public static final String EXERCISE_VIEW = "exercise";
    public static final String EXERCISE_SERVICE_MESSAGE = "I do excercise of Backend Ninja course.";

    private long startTime;

    @Autowired
    @Qualifier("exerciseService")
    private ExerciseService exerciseService;

    @GetMapping("/path1")
    public RedirectView path1(){
        startTime = System.currentTimeMillis();
        return new RedirectView("/exercise/path2");
    }

    @GetMapping("/path2")
    public ModelAndView path2(){

        ModelAndView modelAndView = new ModelAndView(EXERCISE_VIEW);
        modelAndView.addObject("service_message", EXERCISE_SERVICE_MESSAGE);
        exerciseService.showLogMessage();
        LOGGER.info("Response Time: " + (System.currentTimeMillis() - startTime) + " ms");
        return modelAndView;
    }
}
