package com.example.paf_mysql.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.example.paf_mysql.model.Department;

@Repository
public class DepartmentRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Department> findAll() {
        String sql = "select * from departments";
        List<Department> departments = new ArrayList<>();
        SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);

        while (rs.next()) {
            Department d = new Department();
            d.setDeptId(rs.getInt("dept_id"));
            d.setName(rs.getString("name"));
            departments.add(d);
        }
        return departments;
    }

    public Department findById(Integer deptId) {
        String sql = "select * from departments where dept_id = ?";
        SqlRowSet rs = jdbcTemplate.queryForRowSet(sql, deptId);

        if (rs.next()) {
            Department dept = new Department();
            dept.setDeptId(rs.getInt("dept_id"));
            dept.setName(rs.getString("name"));
            return dept;
        }
        return null;
    }
}
