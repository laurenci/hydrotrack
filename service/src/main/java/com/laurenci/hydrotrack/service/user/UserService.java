package com.laurenci.hydrotrack.service.user;

import lombok.AllArgsConstructor;

import com.laurenci.hydrotrack.core.user.UserRepository;

@AllArgsConstructor
public class UserService {
    private final UserRepository repository;

    public UserDto addNewUser(NewUserDto newUser) {
        return UserMapper.INSTANCE.fromModelToDto(
                repository.create(UserMapper.INSTANCE.fromNewDtoToModel(newUser))
        );
    }

    public UserDto getUserById(Long userId) {
        return UserMapper.INSTANCE.fromModelToDto(
                repository.readById(userId)
        );
    }

    public UserDto editUser(UserDto editedUser) {
        return UserMapper.INSTANCE.fromModelToDto(
                repository.update(UserMapper.INSTANCE.fromDtoToModel(editedUser))
        );
    }

    public UserDto calculateDailyAmount(BodyInfoDto bodyInfoDto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
