package com.luxoft.SortingRecords.rest;

import com.luxoft.SortingRecords.entity.Employee;
import com.luxoft.SortingRecords.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/employee", params = {"!sorting", "!asc", "!position", "!firstName", "!lastName"})
    List<Employee> getAll() {

        return employeeService.findAll();
    }

    // GET /employee?sorting=firstName&asc=true
    @GetMapping(value = "/employee", params = {"sorting", "asc"})
    List<Employee> getAllSorted(@RequestParam("sorting") String sorting,
                                @RequestParam("asc") String asc) {

        if (asc.equals("false"))
            return employeeService.findAllSortedBy(sorting, false);
        else
            return employeeService.findAllSortedBy(sorting, true);
    }

    // GET /employee?position=DBA
    @GetMapping(value = "/employee", params = "position")
    List<Employee> getAllByPosition(@RequestParam("position") String position) {

        return employeeService.findByPosition(position);
    }

    // GET /employee?firstName=John
    @GetMapping(value = "/employee", params = "firstName")
    List<Employee> getAllByFirstName(@RequestParam("firstName") String firstName) {

        return employeeService.findByFirstName(firstName);
    }

    // GET /employee?lastName=Weber
    @GetMapping(value = "/employee", params = "lastName")
    List<Employee> getAllByLastName(@RequestParam("lastName") String lastName) {

        return employeeService.findByLastName(lastName);
    }


    @GetMapping("/employee/{id}")
    Optional<Employee> getAll(@PathVariable("id") Integer id) {

        return employeeService.findById(id);
    }
}
