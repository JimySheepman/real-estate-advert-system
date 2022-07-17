package com.example.authservice.controllers;

import com.example.authservice.dto.CreateUserRequestModel;
import com.example.authservice.dto.UserResponseModel;
import com.example.authservice.models.Role;
import com.example.authservice.models.User;
import com.example.authservice.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseModel> save(@RequestBody @Valid CreateUserRequestModel createUserDTO){
        return ResponseEntity.ok(userService.save(createUserDTO, Role.USER));
    }

    @GetMapping("/users")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<UserResponseModel> list(){
        return userService.list();
    }

}
