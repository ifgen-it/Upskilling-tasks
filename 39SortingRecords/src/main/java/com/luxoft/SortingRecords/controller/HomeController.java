package com.luxoft.SortingRecords.controller;

import com.luxoft.SortingRecords.entity.Employee;
import com.luxoft.SortingRecords.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class HomeController {

    private EmployeeService employeeService;

    public HomeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/home")
    public String home(){

        return "home";
    }

    @GetMapping("/home/employee")
    public String newEmployee(){

        return "employee";
    }

    @GetMapping("/home/employee/{id}")
    public String editEmployee(@PathVariable("id") Integer id, Model model){


        Optional<Employee> emp = employeeService.findById(id);
        if (emp.isPresent()){
            model.addAttribute("employee", emp.get());
            return "employee";
        }
        else {
            return "redirect:/home";
        }
    }

    @GetMapping("/home/employee/{id}/delete")
    public String deleteEmployee(@PathVariable("id") Integer id, Model model){

        Optional<Employee> emp = employeeService.findById(id);
        if (emp.isPresent()){
            model.addAttribute("employee", emp.get());
            return "delete-employee";
        }
        else {
            return "redirect:/home";
        }
    }
}
