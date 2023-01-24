package com.example.unibot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.unibot.entity.Lector;

public interface LectorRepository extends JpaRepository<Lector, String> {

    @Query("select lec.fullName from Lector as lec"
        + " where lec.fullName like %?1%")
    List<String> searchLectorsName(String template);
}
