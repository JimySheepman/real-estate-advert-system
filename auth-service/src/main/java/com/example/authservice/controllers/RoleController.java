package com.example.authservice.controllers;

import com.example.authservice.models.Role;
import com.example.authservice.services.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class RoleController {

    private final UserService userService;

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public Role save(@RequestBody Role role){
        return userService.save(role);
    }

}
