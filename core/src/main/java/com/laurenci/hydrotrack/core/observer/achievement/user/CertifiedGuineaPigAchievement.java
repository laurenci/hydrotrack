package com.laurenci.hydrotrack.core.observer.achievement.user;

import java.time.LocalDate;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import com.laurenci.hydrotrack.core.messaging.MessageBrokerService;
import com.laurenci.hydrotrack.core.observer.achievement.Achievement;
import com.laurenci.hydrotrack.core.observer.achievement.AchievementMessage;
import com.laurenci.hydrotrack.core.user.UserRepository;

public class CertifiedGuineaPigAchievement extends Achievement {
    private static final LocalDate BEFORE_DATE = LocalDate.of(2025, 6, 20);

    private final UserRepository repository;
    private final MessageBrokerService messageBrokerService;

    public CertifiedGuineaPigAchievement(UserRepository repository, MessageBrokerService messageBrokerService) {
        super("Certified Guinea Pig", """
                        Awarded to users who registered during the experimental phase of my bachelor's thesis.
                        Thanks for being part of the experiment 🧪
                        """);

        this.repository = repository;
        this.messageBrokerService = messageBrokerService;
    }

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    @SneakyThrows
    public void update(Long userId) {
        var user = repository.readById(userId);
        if (user == null) {
            return;
        }

        if (LocalDate.now().isBefore(BEFORE_DATE)) {
            messageBrokerService.publish("achievement",
                    mapper.writeValueAsString(new AchievementMessage(userId, name, description)));
        }
    }
}
