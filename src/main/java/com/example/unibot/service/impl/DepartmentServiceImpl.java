package com.example.unibot.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.unibot.entity.Department;
import com.example.unibot.repository.DepartmentRepository;
import com.example.unibot.repository.LectorRepository;
import com.example.unibot.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    public static final String DEPARTMENT_NOT_FOUND =
        "Such department not found! Please, try again!";
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository,
        LectorRepository lectorRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public String getHeadOfDepartment(String departmentName) {
        return departmentExistsByName(departmentName) ?
            departmentRepository.getHeadOfDepFullName(departmentName) :
            DEPARTMENT_NOT_FOUND;
    }

    @Override public String getDepartmentStatistics(String departmentName) {
        return departmentExistsByName(departmentName) ?
            formatStatistics(
                departmentRepository.getDepartmentStatistics(departmentName)) :
            DEPARTMENT_NOT_FOUND;
    }

    @Override public BigDecimal getAvgSalary(String departmentName) {
        return departmentExistsByName(departmentName) ?
            departmentRepository.getAvgSalary(departmentName) :
            BigDecimal.ZERO;
    }

    @Override public Integer getEmployeesCount(String departmentName) {
        return departmentRepository.getEmployeesCount(departmentName);
    }

    private boolean departmentExistsByName(String departmentName) {
        return departmentRepository.exists(
            Example.of(new Department(null, departmentName, null)));
    }

    private String formatStatistics(List<String> stats) {
        StringBuilder result = new StringBuilder();
        for (String line : stats) {
            result.append(line.replace(",", "s - ")).append("\n");
        }
        return result.toString();
    }
}
