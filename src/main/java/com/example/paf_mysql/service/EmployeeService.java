package com.example.paf_mysql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.paf_mysql.model.Employee;
import com.example.paf_mysql.repo.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repo;

    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    public Employee getEmployeeById(int empId) {
        return repo.findById(empId);
    }

    public Boolean createEmployee(Employee emp) {
        return repo.save(emp);
    }

    public Boolean updateEmployee(int empId, Employee emp) {
        return repo.update(empId, emp);
    }
}
