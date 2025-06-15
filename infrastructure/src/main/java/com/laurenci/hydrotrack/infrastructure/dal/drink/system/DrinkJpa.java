package com.laurenci.hydrotrack.infrastructure.dal.drink.system;

import com.laurenci.hydrotrack.infrastructure.dal.drink.DrinkTypeJpa;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "drinks")
@Data
public class DrinkJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "type", nullable = false)
    private DrinkTypeJpa type;

    @Column(length = 48)
    private String brand;

    @Column(length = 48, nullable = false)
    private String name;
}
