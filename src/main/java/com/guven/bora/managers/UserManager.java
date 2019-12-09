package com.guven.bora.managers;

import com.guven.bora.models.User;
import com.guven.bora.services.UserService;

import java.util.Collections;
import java.util.List;

public class UserManager {


    private final UserService userService;

    public UserManager(UserService userService) {

        this.userService = userService;
    }

    public List <User> getAllUsers() {
//        return Collections.EMPTY_LIST;
        return userService.getAllUsers();
    }
}
