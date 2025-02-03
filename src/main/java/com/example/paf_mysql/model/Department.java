package com.example.paf_mysql.model;

import java.sql.ResultSet;
import java.sql.SQLException;


import jakarta.json.Json;
import jakarta.json.JsonObject;

public class Department {
    private Integer deptId;
    private String name;

    // Getters and Setters
    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Convert to JSON
    public JsonObject toJson() {
        JsonObject json = Json.createObjectBuilder()
                .add("deptId", deptId)
                .add("name", name)
                .build();
        return json;
    }

    // Map SQL result to Department object
    public static Department fromResultSet(ResultSet rs) throws SQLException {
        Department dept = new Department();
        dept.setDeptId(rs.getInt("dept_id"));
        dept.setName(rs.getString("name"));
        return dept;
    }
}
