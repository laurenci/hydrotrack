package com.laurenci.hydrotrack.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.laurenci.hydrotrack.core.drink.custom.CustomDrinkRepository;
import com.laurenci.hydrotrack.core.drink.system.DrinkRepository;
import com.laurenci.hydrotrack.core.observer.Publisher;
import com.laurenci.hydrotrack.core.observer.achievement.Achievement;
import com.laurenci.hydrotrack.core.observer.achievement.AchievementEvent;
import com.laurenci.hydrotrack.core.record.RecordRepository;
import com.laurenci.hydrotrack.core.report.ReportRepository;
import com.laurenci.hydrotrack.core.user.UserRepository;
import com.laurenci.hydrotrack.service.calculation.CalculationService;
import com.laurenci.hydrotrack.service.drink.custom.CustomDrinkService;
import com.laurenci.hydrotrack.service.drink.system.DrinkService;
import com.laurenci.hydrotrack.service.record.RecordService;
import com.laurenci.hydrotrack.service.report.ReportService;
import com.laurenci.hydrotrack.service.user.UserService;
import com.laurenci.hydrotrack.service.user.AchievementSupportUserService;

@Configuration
public class ServiceConfiguration {

    @Bean
    public UserService userService(UserRepository userRepository, Publisher<Long, AchievementEvent, Achievement> achievementPublisher){
        return new AchievementSupportUserService(userRepository, achievementPublisher);
    }

    @Bean
    public ReportService reportService(ReportRepository reportRepository) {
        return new ReportService(reportRepository);
    }

    @Bean
    public RecordService recordService(RecordRepository recordRepository, DrinkRepository drinkRepository,
                                       CustomDrinkRepository customDrinkRepository) {
        return new RecordService(recordRepository, drinkRepository, customDrinkRepository);
    }

    @Bean
    public DrinkService drinkService(DrinkRepository drinkRepository) {
        return new DrinkService(drinkRepository);
    }

    @Bean
    public CustomDrinkService customDrinkService(CustomDrinkRepository customDrinkRepository) {
        return new CustomDrinkService(customDrinkRepository);
    }

    @Bean
    public CalculationService calculationService() {
        return new CalculationService();
    }
}

