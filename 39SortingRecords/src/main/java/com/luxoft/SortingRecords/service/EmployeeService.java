package com.luxoft.SortingRecords.service;

import com.luxoft.SortingRecords.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> findAll();

    List<Employee> findAllSortedBy(String field, boolean asc);

    Optional<Employee> findById(Integer id);

    List<Employee> findByPosition(String position);

    List<Employee> findByFirstName(String firstName);

    List<Employee> findByLastName(String lastName);

    Employee create(Employee employee);

    void delete(Integer id);

    Employee update(Integer id, Employee newEmployee);

}
