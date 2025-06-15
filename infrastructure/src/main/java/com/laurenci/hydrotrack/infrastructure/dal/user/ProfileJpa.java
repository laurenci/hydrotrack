package com.laurenci.hydrotrack.infrastructure.dal.user;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

import com.laurenci.hydrotrack.core.user.Sex;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "profile")
@Data
public class ProfileJpa {
    @Id
    @Column(name = "user_id")
    private Long userId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private UserJpa user;

    @Column(name = "first_name", length = 32)
    private String firstName;

    @Column(name = "last_name", length = 32)
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Sex sex;

    @Column(name = "birthday_date")
    private LocalDate birthdayDate;
}
