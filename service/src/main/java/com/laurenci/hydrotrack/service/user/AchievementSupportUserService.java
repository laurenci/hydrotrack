package com.laurenci.hydrotrack.service.user;

import com.laurenci.hydrotrack.core.observer.Publisher;
import com.laurenci.hydrotrack.core.observer.achievement.Achievement;
import com.laurenci.hydrotrack.core.observer.achievement.AchievementEvent;
import com.laurenci.hydrotrack.core.user.UserRepository;

public class AchievementSupportUserService extends UserService {
    private final Publisher<Long, AchievementEvent, Achievement> achievementPublisher;

    public AchievementSupportUserService(
            UserRepository repository, Publisher<Long, AchievementEvent, Achievement> achievementPublisher) {
        super(repository);
        this.achievementPublisher = achievementPublisher;
    }

    @Override
    public UserDto addNewUser(NewUserDto newUser) {
        var createdUser = super.addNewUser(newUser);
        achievementPublisher.notifySubscribers(createdUser.id(), AchievementEvent.USER_CREATED);

        return createdUser;
    }
}
