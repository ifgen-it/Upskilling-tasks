package com.luxoft.SortingRecords.rest;

import com.luxoft.SortingRecords.entity.Employee;
import com.luxoft.SortingRecords.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/employee", params = {"!sorting", "!asc", "!position", "!firstName", "!lastName"})
    public List<Employee> getAll() {

        return employeeService.findAll();
    }

    // GET /employee?sorting=firstName&asc=true
    @GetMapping(value = "/employee", params = {"sorting", "asc"})
    public List<Employee> getAllSorted(@RequestParam("sorting") String sorting,
                                @RequestParam("asc") String asc) {

        if (asc.equals("false"))
            return employeeService.findAllSortedBy(sorting, false);
        else
            return employeeService.findAllSortedBy(sorting, true);
    }

    // GET /employee?position=DBA
    @GetMapping(value = "/employee", params = "position")
    public List<Employee> getAllByPosition(@RequestParam("position") String position) {

        return employeeService.findByPosition(position);
    }

    // GET /employee?firstName=John
    @GetMapping(value = "/employee", params = "firstName")
    public List<Employee> getAllByFirstName(@RequestParam("firstName") String firstName) {

        return employeeService.findByFirstName(firstName);
    }

    // GET /employee?lastName=Weber
    @GetMapping(value = "/employee", params = "lastName")
    public List<Employee> getAllByLastName(@RequestParam("lastName") String lastName) {

        return employeeService.findByLastName(lastName);
    }


    @GetMapping("/employee/{id}")
    public Optional<Employee> getAll(@PathVariable("id") Integer id) {

        return employeeService.findById(id);
    }

    @PostMapping("/employee")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee create(@RequestBody Employee employee){

        Employee employeeWithId = employeeService.create(employee);
        return employeeWithId;
    }

    @DeleteMapping("/employee/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id){

        employeeService.delete(id);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> editEmployee(@PathVariable("id") Integer id,
                                       @RequestBody Employee newEmployee){

        Employee employee = employeeService.update(id, newEmployee);
        if (employee == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.status(HttpStatus.OK).body(employee);
    }
}
