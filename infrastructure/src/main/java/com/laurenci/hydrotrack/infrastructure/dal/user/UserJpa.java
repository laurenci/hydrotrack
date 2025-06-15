package com.laurenci.hydrotrack.infrastructure.dal.user;

import jakarta.persistence.Column;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class UserJpa {
    @Id
    private Long id;

    @Column(nullable = false, length = 32)
    private String username;

    @Column(name = "daily_amount", nullable = false)
    private Double expectedDailyAmount;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, optional = false)
    @PrimaryKeyJoinColumn
    private ProfileJpa profile;
}

