package com.luxoft.SortingRecords.controller;

import com.luxoft.SortingRecords.entity.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;


@Controller
public class HomeController {

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

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/employee/" + id;
        ResponseEntity<Employee> response = null;
        try {
            response = restTemplate.getForEntity(url, Employee.class);
        }
        catch (Exception e){
            System.out.println("Incorrect employee id=" + id);
            System.out.println(e);
        }

        if (response !=null && response.getStatusCode().equals(HttpStatus.OK)){
            Employee employee = response.getBody();
            model.addAttribute("employee", employee);
            return "employee";
        }
        else {
            return "redirect:/home";
        }
    }

    @GetMapping("/home/employee/{id}/delete")
    public String deleteEmployee(@PathVariable("id") Integer id, Model model){

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/employee/" + id;
        ResponseEntity<Employee> response = null;
        try {
            response = restTemplate.getForEntity(url, Employee.class);
        }
        catch (Exception e){
            System.out.println("Incorrect employee id=" + id);
            System.out.println(e);
        }

        if (response !=null && response.getStatusCode().equals(HttpStatus.OK)){
            Employee employee = response.getBody();
            model.addAttribute("employee", employee);
            return "delete-employee";
        }
        else {
            return "redirect:/home";
        }
    }
}
