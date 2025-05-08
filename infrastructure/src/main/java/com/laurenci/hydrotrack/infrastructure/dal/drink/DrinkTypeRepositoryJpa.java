package com.laurenci.hydrotrack.infrastructure.dal.drink;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DrinkTypeRepositoryJpa extends JpaRepository<DrinkTypeJpa, String> {
}
