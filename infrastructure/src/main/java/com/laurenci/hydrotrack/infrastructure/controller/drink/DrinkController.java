package com.laurenci.hydrotrack.infrastructure.controller.drink;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laurenci.hydrotrack.service.drink.system.DrinkDto;
import com.laurenci.hydrotrack.service.drink.system.DrinkService;

@RestController
@RequestMapping("/drinks")
@RequiredArgsConstructor
public class DrinkController {
    private final DrinkService drinkService;

    @GetMapping("/type/{type}")
    public ResponseEntity<List<DrinkDto>> getDrinksByType(@PathVariable String type) {
        return ResponseEntity.ok(drinkService.getDrinksByType(type));
    }

    @GetMapping("/group/{group}")
    public ResponseEntity<List<DrinkDto>> getDrinksByGroup(@PathVariable String group) {
        return ResponseEntity.ok(drinkService.getDrinksByGroup(group));
    }
}

