package com.luxoft.SortingRecords.service;

import com.luxoft.SortingRecords.entity.Employee;
import com.luxoft.SortingRecords.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();
        Iterable<Employee> emps = repository.findAll();
        emps.forEach(e -> employees.add(e));
        return employees;
    }

    @Override
    public Optional<Employee> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public List<Employee> findByPosition(String position) {
        return repository.findByPosition(position);
    }

    @Override
    public List<Employee> findByFirstName(String firstName) {
        return repository.findByFirstName(firstName);
    }

    @Override
    public List<Employee> findByLastName(String lastName) {
        return repository.findByLastName(lastName);
    }

    @Override
    public List<Employee> findAllSortedBy(String field, boolean asc) {
        List<Employee> employees = findAll();
        switch (field) {
            case "firstName":
                if (asc)
                    employees.sort(Comparator.comparing(Employee::getFirstName));
                else
                    employees.sort(Comparator.comparing(Employee::getFirstName).reversed());
                break;
            case "lastName":
                if (asc)
                    employees.sort(Comparator.comparing(Employee::getLastName));
                else
                    employees.sort(Comparator.comparing(Employee::getLastName).reversed());
                break;
            case "position":
                if (asc)
                    employees.sort(Comparator.comparing(Employee::getPosition));
                else
                    employees.sort(Comparator.comparing(Employee::getPosition).reversed());
                break;
            case "id":
                if (asc)
                    employees.sort(Comparator.comparing(Employee::getId));
                else
                    employees.sort(Comparator.comparing(Employee::getId).reversed());
                break;
            default:
                break;
        }
        return employees;
    }

    @Override
    public Employee create(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Employee update(Integer id, Employee newEmployee) {

        Optional<Employee> employee = repository.findById(id);
        if (!employee.isPresent())
            return null;

        Employee emp = employee.get();
        emp.setFirstName(newEmployee.getFirstName());
        emp.setLastName(newEmployee.getLastName());
        emp.setPosition(newEmployee.getPosition());
        emp.setSeparationDate(newEmployee.getSeparationDate());

        return repository.save(emp);
    }


}
