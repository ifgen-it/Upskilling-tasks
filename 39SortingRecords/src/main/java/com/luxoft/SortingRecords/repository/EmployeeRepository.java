package com.luxoft.SortingRecords.repository;

import com.luxoft.SortingRecords.entity.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    Iterable<Employee> findAll();

    Optional<Employee> findById(Integer id);

    List<Employee> findByPosition(String position);

    List<Employee> findByFirstName(String firstName);

    List<Employee> findByLastName(String lastName);


    Employee save(Employee employee);
}
