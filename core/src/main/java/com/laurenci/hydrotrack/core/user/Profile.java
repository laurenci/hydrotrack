package com.laurenci.hydrotrack.core.user;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Profile {
    private Long userId;
    private String firstName;
    private String lastName;
    private Sex sex = Sex.UNCERTAIN;
    private LocalDate birthdayDate;
}
