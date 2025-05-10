package com.laurenci.hydrotrack.infrastructure.controller.drink;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laurenci.hydrotrack.service.drink.custom.CustomDrinkDto;
import com.laurenci.hydrotrack.service.drink.custom.CustomDrinkService;
import com.laurenci.hydrotrack.service.drink.custom.NewCustomDrinkDto;

@RestController
@RequestMapping("/custom-drinks")
@RequiredArgsConstructor
public class CustomDrinkController {
    private final CustomDrinkService customDrinkService;

    @PostMapping
    public ResponseEntity<CustomDrinkDto> addNewCustomDrink(@RequestBody NewCustomDrinkDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customDrinkService.addNewCustomDrink(dto));
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<CustomDrinkDto>> getCustomDrinksByType(@PathVariable String type) {
        return ResponseEntity.ok(customDrinkService.getCustomDrinksByType(type));
    }

    @GetMapping("/group/{group}")
    public ResponseEntity<List<CustomDrinkDto>> getCustomDrinksByGroup(@PathVariable String group) {
        return ResponseEntity.ok(customDrinkService.getCustomDrinksByGroup(group));
    }

    @PutMapping
    public ResponseEntity<CustomDrinkDto> editCustomDrink(@RequestBody CustomDrinkDto dto) {
        return ResponseEntity.ok(customDrinkService.editCustomDrink(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomDrinkById(@PathVariable Long id) {
        customDrinkService.deleteCustomDrinkById(id);
        return ResponseEntity.noContent().build();
    }
}

