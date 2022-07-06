package com.example.authservice.service;

import com.example.authservice.dto.UserCreateDTO;
import com.example.authservice.dto.UserViewDTO;

public interface UserService {
    UserViewDTO createUser (UserCreateDTO userCreateDTO);
}
