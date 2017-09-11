package com.udemy.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class Example5Controller {

    public static final String ERROR500 = "500";

    @GetMapping("/error500")
    public String errorPage() {
        return ERROR500;
    }

}
