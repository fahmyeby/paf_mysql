package com.example.paf_mysql.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.example.paf_mysql.model.Employee;

@Repository
public class EmployeeRepository {

    @Autowired
    private JdbcTemplate template;

    public List<Employee> findAll() {
        String sql = "SELECT * FROM employees";
        List<Employee> employees = new ArrayList<>();
        SqlRowSet rs = template.queryForRowSet(sql);

        while (rs.next()) {
            Employee emp = new Employee();
            emp.setEmpId(rs.getInt("emp_id"));
            emp.setName(rs.getString("name"));
            emp.setSalary(rs.getDouble("salary"));
            emp.setDeptId(rs.getInt("dept_id"));
            emp.setDateOfBirth(rs.getDate("date_of_birth"));
            employees.add(emp);
        }
        return employees;
    }

    public Employee findById(int empId) {
        String sql = "SELECT * FROM employees WHERE emp_id = ?";
        SqlRowSet rs = template.queryForRowSet(sql, empId);

        if (rs.next()) {
            Employee emp = new Employee();
            emp.setEmpId(rs.getInt("emp_id"));
            emp.setName(rs.getString("name"));
            emp.setSalary(rs.getDouble("salary"));
            emp.setDeptId(rs.getInt("dept_id"));
            emp.setDateOfBirth(rs.getDate("date_of_birth"));
            return emp;
        }
        return null;
    }

    public boolean save(Employee emp) {
        String sql = "INSERT INTO employees (name, salary, dept_id, date_of_birth) VALUES (?, ?, ?, ?)";
        int updated = template.update(sql, emp.getName(), emp.getSalary(), emp.getDeptId(), emp.getDateOfBirth());
        return updated > 0;
    }

    public boolean update(int empId, Employee emp) {
        String sql = "UPDATE employees SET name = ?, salary = ?, dept_id = ?, date_of_birth = ? WHERE emp_id = ?";
        int updated = template.update(sql, emp.getName(), emp.getSalary(), emp.getDeptId(), emp.getDateOfBirth(),
                empId);
        return updated > 0;
    }
}
