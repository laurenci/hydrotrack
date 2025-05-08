package com.laurenci.hydrotrack.infrastructure.dal.drink;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import com.laurenci.hydrotrack.core.drink.DrinkGroup;

@Entity
@Table(name = "drink_types")
@Data
public class DrinkTypeJpa {
    @Id
    @Column(length = 48)
    private String type;

    @Enumerated(EnumType.STRING)
    @Column(name = "`group`", nullable = false)
    private DrinkGroup group;
}

