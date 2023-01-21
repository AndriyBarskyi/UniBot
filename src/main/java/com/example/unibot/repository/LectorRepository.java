package com.example.unibot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.unibot.entity.Lector;

public interface LectorRepository extends JpaRepository<Lector, String> {
}
