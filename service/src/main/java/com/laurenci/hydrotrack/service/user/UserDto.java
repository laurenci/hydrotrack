package com.laurenci.hydrotrack.service.user;

public record UserDto(Long id, String username, Double expectedDailyAmount, ProfileDto profile) {
}
