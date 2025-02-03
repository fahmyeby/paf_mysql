package com.example.paf_mysql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.paf_mysql.model.Department;
import com.example.paf_mysql.service.DepartmentService;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService service;

    @GetMapping
    public ResponseEntity<String> getAllDepartments() {
        List<Department> departments = service.getAllDepartments();
        JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
        for (Department dept : departments) {
            arrBuilder.add(dept.toJson());
        }
        return ResponseEntity.ok(arrBuilder.build().toString());
    }

    @GetMapping("/{deptId}")
    public ResponseEntity<String> getDepartment(@PathVariable int deptId) {
        Department dept = service.getDepartmentById(deptId);
        if (dept != null) {
            return ResponseEntity.ok(dept.toJson().toString());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
