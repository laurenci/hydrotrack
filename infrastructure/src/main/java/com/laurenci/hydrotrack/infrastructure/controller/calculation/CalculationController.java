package com.laurenci.hydrotrack.infrastructure.controller.calculation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laurenci.hydrotrack.service.calculation.CalculationService;
import com.laurenci.hydrotrack.service.calculation.BodyInfoDto;

@RestController
@RequestMapping("/calculations")
@RequiredArgsConstructor
public class CalculationController {
    private final CalculationService calculationService;

    @PostMapping("/daily-amount")
    public ResponseEntity<Double> calculateDailyAmount(@RequestBody BodyInfoDto bodyInfoDto) {
        return ResponseEntity.ok(calculationService.determineDailyAmount(bodyInfoDto));
    }
}
