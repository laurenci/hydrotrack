package com.laurenci.hydrotrack.infrastructure.configuration;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.laurenci.hydrotrack.core.messaging.MessageBrokerService;
import com.laurenci.hydrotrack.core.observer.Publisher;
import com.laurenci.hydrotrack.core.observer.PublisherBuilder;
import com.laurenci.hydrotrack.core.observer.achievement.Achievement;
import com.laurenci.hydrotrack.core.observer.achievement.AchievementEvent;
import com.laurenci.hydrotrack.core.observer.achievement.user.CertifiedGuineaPigAchievement;
import com.laurenci.hydrotrack.core.user.UserRepository;

@Component
public class AchievementConfiguration {
    @Bean
    public List<Achievement> createdUserAchievements(UserRepository userRepository, MessageBrokerService messageBrokerService) {
        return List.of(
                new CertifiedGuineaPigAchievement(userRepository, messageBrokerService)
        );
    }

    @Bean
    public Publisher<Long, AchievementEvent, Achievement> achievementPublisher(List<Achievement> createdUserAchievements) {
        return new PublisherBuilder<Long, AchievementEvent, Achievement>()
                .addSubscribers(AchievementEvent.USER_CREATED, createdUserAchievements)
                .build();
    }
}
