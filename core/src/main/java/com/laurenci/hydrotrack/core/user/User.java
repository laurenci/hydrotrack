package com.laurenci.hydrotrack.core.user;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String username;
    private Double expectedDailyAmount = 0.0;
    private Profile profile = new Profile();
}
