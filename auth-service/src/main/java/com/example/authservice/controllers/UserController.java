package com.example.authservice.controllers;

import com.example.authservice.dto.AddRoleRequestDTO;
import com.example.authservice.models.User;
import com.example.authservice.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> save(@RequestBody User user){
        userService.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @GetMapping("/api/v1/users")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public List<User> list(){
        return userService.list();
    }


    @PatchMapping("/api/v1/users")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public void addRoles(@RequestBody AddRoleRequestDTO request){
    userService.addRoleTo(request.getUsername(),request.getRole());
    }
}
