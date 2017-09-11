package com.udemy.backendninja.controller;

import com.udemy.backendninja.model.Person;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

@Controller
@RequestMapping("/example3")
public class Example3Controller {

    public static  final String FORM_VIEW = "form";
    public static  final String RESULT_VIEW = "result";

    private static final Log LOGGER = LogFactory.getLog(Example3Controller.class);
    /*@GetMapping("/")
    public String redirect() {
        return "redirect:/example3/showform";
    }*/

    @GetMapping("/")
    public RedirectView redirect() {
        return new RedirectView("/example3/showform");
    }

    @GetMapping("/showform")
    public String showForm(Model model) {
        model.addAttribute("person", new Person());
        return FORM_VIEW;
    }

    @PostMapping("/addperson")
    public ModelAndView addPerson(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult) {
        //LOGGER.info("METHOD: 'addPerson' -- PARAMS: '" + person + "'");
        ModelAndView modelAndView = new ModelAndView(RESULT_VIEW);

        if(bindingResult.hasErrors()) {
            modelAndView.setViewName(FORM_VIEW);
        } else {
            modelAndView.setViewName(RESULT_VIEW);
            modelAndView.addObject("person", person);
        }


        //LOGGER.info("TEMPLATE: '" + RESULT_VIEW + "' -- DATA: '" + person + "'");
        return  modelAndView;
    }
}
