package com.laurenci.hydrotrack.infrastructure.dal.drink.custom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomDrinkRepositoryJpa extends JpaRepository<CustomDrinkJpa, Long> {

    // Custom JPQL query to find custom drinks by type
    @Query("SELECT d FROM CustomDrinkJpa d WHERE d.type.type = :type")
    List<CustomDrinkJpa> findByType(@Param("type") String type);

    // Custom JPQL query to find custom drinks by group
    @Query("SELECT d FROM CustomDrinkJpa d WHERE d.type.group = :group")
    List<CustomDrinkJpa> findByGroup(@Param("group") String group);

    // Custom JPQL query to find custom drinks by userId
    @Query("SELECT c FROM CustomDrinkJpa c WHERE c.user.id = :userId")
    List<CustomDrinkJpa> findByUserId(@Param("userId") Long userId);
}
