package com.example.paf_mysql.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import jakarta.json.Json;
import jakarta.json.JsonObject;

public class Employee {
    private Integer empId;
    private String name;
    private Double salary;
    private Integer deptId;
    private Date dateOfBirth;

    // Getters and Setters
    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    // parse to json obj
    public JsonObject toJson() {
        JsonObject json = Json.createObjectBuilder()
                .add("empId", empId)
                .add("name", name)
                .add("salary", salary)
                .add("deptId", deptId)
                .add("dateOfBirth", dateOfBirth.toString())
                .build();
        return json;
    }

    // map sql result to model 
    public static Employee fromResultSet(ResultSet rs) throws SQLException {
        Employee emp = new Employee();
        emp.setEmpId(rs.getInt("emp_id"));
        emp.setName(rs.getString("name"));
        emp.setSalary(rs.getDouble("salary"));
        emp.setDeptId(rs.getInt("dept_id"));
        emp.setDateOfBirth(rs.getDate("date_of_birth"));
        return emp;
    }
}
