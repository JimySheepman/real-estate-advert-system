package com.example.authservice.dto;

import lombok.Data;

@Data
public class AddRoleRequestDTO {
    private String username;
    private String role;
}
