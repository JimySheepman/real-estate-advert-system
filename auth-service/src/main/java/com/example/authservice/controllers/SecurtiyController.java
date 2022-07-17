package com.example.authservice.controllers;

import com.example.authservice.dto.ResponseModel;
import com.example.authservice.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class SecurtiyController {

    private final UserService userService;

    private final RestTemplate restTemplate;

    @GetMapping("/token/{token}")
    public ResponseEntity<?> getUsernameAuthorities(@PathVariable("token") String token, HttpServletRequest request) {
        ResponseModel response = new ResponseModel();

        return ResponseEntity.status(200).body("succues");
    }

}
