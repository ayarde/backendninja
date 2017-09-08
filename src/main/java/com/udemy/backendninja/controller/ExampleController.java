package com.udemy.backendninja.controller;

import com.udemy.backendninja.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/example")
public class ExampleController {
    public static  final String EXAMPLE_VIEW = "example";
    //First shape
    @GetMapping(value = "/exampleString")
    public String exampleString(Model model){
        model.addAttribute("people", getPeople());
        return EXAMPLE_VIEW;
    }

    //Second shape
    @GetMapping(value = "/exampleMAV")
    public ModelAndView exampleMAV(){
        ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
        mav.addObject("people",getPeople());
        return mav;
    }

    private List<Person> getPeople() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Pepe", 25));
        people.add(new Person("Tony", 20));
        people.add(new Person("Nia", 3));
        people.add(new Person("Bob", 21));

        return people;
    }
}
