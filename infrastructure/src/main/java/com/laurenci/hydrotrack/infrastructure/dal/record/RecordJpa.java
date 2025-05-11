package com.laurenci.hydrotrack.infrastructure.dal.record;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import com.laurenci.hydrotrack.core.drink.DrinkArea;
import com.laurenci.hydrotrack.infrastructure.dal.drink.system.DrinkJpa;

@Entity
@Table(name = "records")
@Data
public class RecordJpa {
    @EmbeddedId
    private RecordIdJpa id;

    @ManyToOne
    @JoinColumn(name = "drink_id", nullable = false, insertable = false, updatable = false)
    private DrinkJpa drink;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DrinkArea area;

    @Column(nullable = false)
    private Double amount;
}

