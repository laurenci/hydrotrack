package com.laurenci.hydrotrack.infrastructure.dal.record;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;

import com.laurenci.hydrotrack.core.record.RecordId;
import com.laurenci.hydrotrack.core.drink.DrinkArea;

@Entity
@Table(name = "records")
@Data
@IdClass(RecordId.class)
public class RecordJpa {
    @Id
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Id
    @Column(name = "drink_id", nullable = false)
    private Long drinkId;

    @Id
    @Column(nullable = false)
    private LocalDateTime date;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DrinkArea area;

    @Column(nullable = false)
    private Double amount;
}

