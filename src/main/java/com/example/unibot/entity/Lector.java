package com.example.unibot.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LECTOR")
public class Lector {
    @Id
    private String id;
    @Column(nullable = false)
    private String fullName;
    @Column(nullable = false)
    private BigDecimal salary;
    @ManyToOne
    @JoinColumn(name = "degree_id", foreignKey = @ForeignKey(name = "fk_lector_degree"))
    private Degree degree;

}
