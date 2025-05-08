package com.laurenci.hydrotrack.infrastructure.dal.drink.custom;

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

import com.laurenci.hydrotrack.infrastructure.dal.user.UserJpa;

@Entity
@Table(name = "custom_drinks")
@Data
public class CustomDrinkJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserJpa user;

    @ManyToOne
    @JoinColumn(name = "type", nullable = false)
    private DrinkTypeJpa type;

    @Column(length = 48)
    private String brand;

    @Column(length = 48, nullable = false)
    private String name;
}

