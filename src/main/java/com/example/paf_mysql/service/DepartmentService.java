package com.example.paf_mysql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.paf_mysql.model.Department;
import com.example.paf_mysql.repo.DepartmentRepository;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository repo;

    public List<Department> getAllDepartments() {
        return repo.findAll();
    }

    public Department getDepartmentById(int deptId) {
        return repo.findById(deptId);
    }
}
