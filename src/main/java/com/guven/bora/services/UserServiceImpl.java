package com.guven.bora.services;

import com.guven.bora.models.User;
import com.guven.bora.repositories.UserRepository;

import java.util.List;

public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List <User> getAllUsers() {
        return this.userRepository.getAllUsers();
    }
}
