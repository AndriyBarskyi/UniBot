package com.example.unibot.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.unibot.entity.Department;

public interface DepartmentRepository extends
    JpaRepository<Department, String> {

    @Query("select lec.fullName from Lector as lec "
        + "where lec=("
        + "select headOfDep from Department "
        + "where lower(name)=lower(?1))")
    String getHeadOfDepFullName(String departmentName);

    @Query("select avg(lec.salary) from Lector as lec "
        + "join LectorDepartment ld on lec.id = ld.lector.id "
        + "join Department d on d.id = ld.department.id "
        + "where d.name = ?1")
    BigDecimal getAvgSalary(String departmentName);

    @Query("select count(lec_dep) from LectorDepartment as lec_dep "
        + "where lower(lec_dep.department.name) = lower(?1)")
    Integer getEmployeesCount(String departmentName);

    @Query("select d.name, count(d.name) from Degree as d "
        + "join Lector lec on lec.degree.id = d.id "
        + "join LectorDepartment ld on ld.lector.id = lec.id "
        + "where ld.department.name = ?1 "
        + "group by d.name")
    List<String> getDepartmentStatistics(String departmentName);

    @Query("select dep.name from Department as dep"
        + " where dep.name like %?1%")
    List<String> searchDepartmentsName(String template);
}
