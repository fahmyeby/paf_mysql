package com.example.paf_mysql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.paf_mysql.model.Employee;
import com.example.paf_mysql.service.EmployeeService;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @GetMapping
    public ResponseEntity<String> getAllEmployees() {
        List<Employee> employees = service.getAllEmployees();
        JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
        for (Employee emp : employees) {
            arrBuilder.add(emp.toJson());
        }
        return ResponseEntity.ok(arrBuilder.build().toString());
    }

    @GetMapping("/{empId}")
    public ResponseEntity<String> getEmployee(@PathVariable int empId) {
        Employee emp = service.getEmployeeById(empId);
        if (emp != null) {
            return ResponseEntity.ok(emp.toJson().toString());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> createEmployee(@RequestBody Employee emp) {
        if (service.createEmployee(emp)) {
            return ResponseEntity.ok("Employee created");
        } else {
            return ResponseEntity.status(500).body("Failed to create employee");
        }
    }

    @PutMapping("/{empId}")
    public ResponseEntity<String> updateEmployee(@PathVariable int empId, @RequestBody Employee emp) {
        if (service.updateEmployee(empId, emp)) {
            return ResponseEntity.ok("Employee updated");
        } else {
            return ResponseEntity.status(500).body("Failed to update employee");
        }
    }
}
