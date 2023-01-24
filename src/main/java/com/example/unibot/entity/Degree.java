package com.example.unibot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DEGREE")
public class Degree {
    @Id
    private String id;

    @Column(nullable = false)
    private String name;
}
