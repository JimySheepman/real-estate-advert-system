package com.example.authservice.services;

import java.util.List;

import com.example.authservice.dto.CreateUserRequestModel;
import com.example.authservice.dto.UserResponseModel;
import com.example.authservice.models.Role;
import com.example.authservice.models.User;

public interface UserService {
    UserResponseModel save(CreateUserRequestModel createUserRequestModel, Role role);
    User get(String username);
    List<UserResponseModel> list();
}
