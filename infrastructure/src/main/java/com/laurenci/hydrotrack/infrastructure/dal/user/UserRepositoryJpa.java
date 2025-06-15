package com.laurenci.hydrotrack.infrastructure.dal.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepositoryJpa extends JpaRepository<UserJpa, Long> {
}
