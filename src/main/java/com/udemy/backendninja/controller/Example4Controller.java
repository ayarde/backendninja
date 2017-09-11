package com.udemy.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class Example4Controller {

    public static final String ERROR404 = "404";

    @GetMapping("/error404")
    public String errorPage() {
        return ERROR404;
    }

}
