package com.laurenci.hydrotrack.infrastructure.dal.user;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import com.laurenci.hydrotrack.core.user.User;
import com.laurenci.hydrotrack.core.user.UserRepository;

@Repository
@Transactional
@AllArgsConstructor
public class ConcreteUserRepository implements UserRepository {
    private final UserRepositoryJpa userRepositoryJpa;

    @Override
    public User create(User user) {
        return UserMapper.INSTANCE.fromEntityToModel(
                userRepositoryJpa.save(UserMapper.INSTANCE.fromModelToEntity(user))
        );
    }

    @Override
    public User readById(Long userId) {
        return UserMapper.INSTANCE.fromEntityToModel(
                userRepositoryJpa.findById(userId).orElseThrow()
        );
    }

    @Override
    public User update(User editedUser) {
        return UserMapper.INSTANCE.fromEntityToModel(
                userRepositoryJpa.save(UserMapper.INSTANCE.fromModelToEntity(editedUser))
        );
    }

    @Override
    public User deleteById(Long userId) {
        var deletedUser = readById(userId);
        userRepositoryJpa.deleteById(userId);
        return deletedUser;
    }
}
