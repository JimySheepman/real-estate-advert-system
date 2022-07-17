package com.example.authservice.dto;

import com.example.authservice.models.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseModel {
    private Long id;
    private String name;
    private String surname;
    private String username;
    private String phoneNumber;
    private String email;
    private Role role;
}
