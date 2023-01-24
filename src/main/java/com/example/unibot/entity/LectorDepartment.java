package com.example.unibot.entity;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LECTOR_DEPARTMENT")
public class LectorDepartment {
    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "lector_id", nullable = false, foreignKey = @ForeignKey(name = "fk_lector_department"))
    private Lector lector;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false, foreignKey = @ForeignKey(name = "fk_department_lector"))
    private Department department;
}
