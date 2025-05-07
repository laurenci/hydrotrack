package com.laurenci.hydrotrack.service.user;


import com.laurenci.hydrotrack.core.user.UserRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserService {
    private final UserRepository repository;

    public UserDto addNewUser(NewUserDto newUser) {
        return null;
    }

    public UserDto getUserById(Long userId) {
        return null;
    }

    public UserDto editUser(UserDto editedUser) {
        return null;
    }

    public UserDto calculateDailyAmount(BodyInfoDto bodyInfoDto) {
        return null;
    }
}
