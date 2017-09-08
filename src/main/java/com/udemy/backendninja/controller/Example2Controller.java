package com.udemy.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example2")
public class Example2Controller {

    public static  final String EXAMPLE2_VIEW = "example2";

    //localhost:8080/example2/request1?nm=Pepo
    //localhost:8080/example2/request1?nm=Pepi
    @GetMapping("/request1")
    public ModelAndView request1(@RequestParam(name="nm", required = false, defaultValue = "NoName")String name) {
        ModelAndView modelAndView = new ModelAndView(EXAMPLE2_VIEW);
        modelAndView.addObject("nm_in_model",name);
        return modelAndView;
    }

    //localhost:8080/example2/request2/JON
    //localhost:8080/example2/request2/TITO
    @GetMapping("/request2/{nm}")
    public ModelAndView request2(@PathVariable("nm")String name){
        ModelAndView modelAndView = new ModelAndView(EXAMPLE2_VIEW);
        modelAndView.addObject("nm_in_model",name);
        return modelAndView;
    }
}
