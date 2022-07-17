package com.example.authservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateUserRequestModel {

    @NotBlank(message = "name is mandatory")
    @Size(min = 3, max = 16)
    private String name;

    @NotBlank(message = "surname is mandatory")
    private String surname;

    @NotBlank(message = "username is mandatory")
    private String username;

    @NotBlank(message = "password is mandatory")
    private String password;

    @NotBlank(message = "phone number is mandatory")
    private String phoneNumber;

    @NotBlank(message = "email is mandatory")
    @Email(message = "email must be valid")
    private String email;
}
