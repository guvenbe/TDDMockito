package com.guven.bora.repositories;

import com.guven.bora.models.User;

import java.util.List;

public interface UserRepository {
    List<User> getAllUsers();
}
