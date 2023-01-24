package com.example.unibot.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.unibot.repository.DepartmentRepository;
import com.example.unibot.repository.LectorRepository;
import com.example.unibot.service.UniversityService;

@Service
public class UniversityServiceImpl implements UniversityService {
    private final LectorRepository lectorRepository;
    private final DepartmentRepository departmentRepository;

    @Autowired
    public UniversityServiceImpl(LectorRepository lectorRepository,
        DepartmentRepository departmentRepository) {
        this.lectorRepository = lectorRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<String> globalSearchBy(String template) {
        List<String> searchResults =
            new LinkedList<>(lectorRepository.searchLectorsName(template));
        searchResults.addAll(
            departmentRepository.searchDepartmentsName(template));
        return !searchResults.isEmpty() ? searchResults :
            List.of("Nothing has been found by template: " + template);
    }
}
