package com.luxoft.SortingRecords.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(){

        return "home";
    }

    @GetMapping("/home/employee")
    public String employee(){

        return "new-employee";
    }
}
