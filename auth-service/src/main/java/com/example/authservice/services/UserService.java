package com.example.authservice.services;

import java.util.List;

import com.example.authservice.dto.CreateUserRequestModel;
import com.example.authservice.models.Role;
import com.example.authservice.models.User;

public interface UserService {
    User save(CreateUserRequestModel createUserRequestModel, Role role);
    User get(String username);
    List<User> list();
}
