package com.example.authservice.controllers;

import com.example.authservice.models.UsernameAndRole;
import com.example.authservice.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class SecurityController {

    private final JwtUtil jwtUtil;



    @GetMapping("/token/{token}")
    public ResponseEntity<UsernameAndRole> getUsernameAuthorities(@PathVariable("token") String token) {
        UsernameAndRole  usernameAndRole= jwtUtil.getUserAndRoleFromToken(token);
        return ResponseEntity.status(200).body(usernameAndRole);
    }

}
