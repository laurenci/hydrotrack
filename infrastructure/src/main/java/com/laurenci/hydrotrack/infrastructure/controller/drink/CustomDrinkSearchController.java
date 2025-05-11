package com.laurenci.hydrotrack.infrastructure.controller.drink;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laurenci.hydrotrack.core.drink.DrinkType;
import com.laurenci.hydrotrack.core.drink.DrinkGroup;
import com.laurenci.hydrotrack.service.drink.custom.CustomDrinkDto;
import com.laurenci.hydrotrack.service.drink.custom.CustomDrinkService;

@RestController
@RequestMapping("/users/{id}/custom-drinks")
@RequiredArgsConstructor
public class CustomDrinkSearchController {
    private final CustomDrinkService customDrinkService;

    @GetMapping("/search")
    public ResponseEntity<List<CustomDrinkDto>> getCustomDrinksByDrinkType(
            @PathVariable("id") Long userId,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) DrinkGroup group) {
        DrinkType typeModel = new DrinkType();
        typeModel.setType(type);
        typeModel.setGroup(group);
        return ResponseEntity.ok(customDrinkService.getCustomDrinksByUserIdAndDrinkType(userId, typeModel));
    }

    @GetMapping()
    public ResponseEntity<List<CustomDrinkDto>> getCustomDrinks(
            @PathVariable("id") Long userId) {
        return ResponseEntity.ok(customDrinkService.getCustomDrinksByUserId(userId));
    }
}
