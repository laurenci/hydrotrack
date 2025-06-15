package com.laurenci.hydrotrack.infrastructure.controller.drink;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laurenci.hydrotrack.core.drink.DrinkGroup;
import com.laurenci.hydrotrack.core.drink.DrinkType;
import com.laurenci.hydrotrack.service.drink.system.DrinkDto;
import com.laurenci.hydrotrack.service.drink.system.DrinkService;

@RestController
@RequestMapping("/drinks")
@RequiredArgsConstructor
public class DrinkController {
    private final DrinkService drinkService;

    @GetMapping("/search")
    public ResponseEntity<List<DrinkDto>> searchDrinks(
            @RequestParam(required = false) String type,
            @RequestParam(required = false) DrinkGroup group) {
        DrinkType typeDto = new DrinkType();
        typeDto.setType(type);
        typeDto.setGroup(group);
        return ResponseEntity.ok(drinkService.getDrinksByDrinkType(typeDto));
    }

    @GetMapping
    public  ResponseEntity<List<DrinkDto>> getAllDrinks() {
        return ResponseEntity.ok(drinkService.getAllDrinks());
    }
}

