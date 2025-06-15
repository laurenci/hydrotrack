package com.laurenci.hydrotrack.infrastructure.dal.record;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Embeddable
@Data
public class RecordIdJpa implements Serializable {
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "drink_id", nullable = false)
    private Long drinkId;

    @Column(name = "date", nullable = false, updatable = false)
    private LocalDateTime date;
}
