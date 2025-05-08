package com.laurenci.hydrotrack.infrastructure.dal.drink.system;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DrinkRepositoryJpa extends JpaRepository<DrinkJpa, Long> {

    // Custom JPQL query to find drinks by type
    @Query("SELECT d FROM DrinkJpa d WHERE d.type.type = :type")
    List<DrinkJpa> findByType(@Param("type") String type);

    // Custom JPQL query to find drinks by group
    @Query("SELECT d FROM DrinkJpa d WHERE d.type.group = :group")
    List<DrinkJpa> findByGroup(@Param("group") String group);
}
