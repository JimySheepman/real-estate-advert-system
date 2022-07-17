package com.example.authservice.controllers;

import com.example.authservice.dto.AddRoleRequestDTO;
import com.example.authservice.dto.CreateUserRequestModel;
import com.example.authservice.models.Role;
import com.example.authservice.models.User;
import com.example.authservice.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> save(@RequestBody CreateUserRequestModel createUserDTO){
        userService.save(createUserDTO, Role.USER);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/users")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<User> list(){
        return userService.list();
    }

}
