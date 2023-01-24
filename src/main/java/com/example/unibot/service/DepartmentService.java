package com.example.unibot.service;

import java.math.BigDecimal;

public interface DepartmentService {
    String getHeadOfDepartment(String departmentName);

    String getDepartmentStatistics(String departmentName);

    BigDecimal getAvgSalary(String departmentName);

    Integer getEmployeesCount(String departmentName);
}
