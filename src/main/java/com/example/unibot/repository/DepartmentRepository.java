package com.example.unibot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.unibot.entity.Department;

public interface DepartmentRepository extends
    JpaRepository<Department, String> {
}
