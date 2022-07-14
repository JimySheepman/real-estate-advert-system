package com.example.authservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.authservice.models.User;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}

