package com.laurenci.hydrotrack.service.user;

import com.laurenci.hydrotrack.core.user.Sex;

public record ProfileDto(Long userId, String firstName, String lastName, Sex sex) {

}
