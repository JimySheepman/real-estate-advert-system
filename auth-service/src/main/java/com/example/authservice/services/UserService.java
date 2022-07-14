package com.example.authservice.services;

import java.util.List;

import com.example.authservice.models.Role;
import com.example.authservice.models.User;

public interface UserService {
    User save(User user);
    Role save(Role role);
    void addRoleTo(String username, String role);
    User get(String username);
    List<User> list();
}
