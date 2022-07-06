package com.example.authservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCreateDTO {

    @NotNull(message = "User Name cannot be null")
    @Size(min = 4,max = 24,message = "User Name length must be between {min} and {max}")
    private String userName;

    @NotNull(message = "First Name cannot be null")
    @Size(min = 2,max = 32,message = "First Name length must be between {min} and {max}")
    private  String firstName;

    @NotNull(message = "Last Name cannot be null")
    @Size(min = 3,max = 32,message = "Last Name length must be between {min} and {max}")
    private  String lastName;

    @NotNull(message = "Phone Number cannot be null")
    @Size(min = 11,max = 11,message = "First Name length must be between {min} and {max}")
    private  String phoneNumber;

    @NotNull(message = "Email cannot be empty")
    @Email(message = "Email is not valid", regexp = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$")
    private String email;

    @NotNull(message = "Last Name cannot be null")
    @Size(min = 8,max = 32,message = "Last Name length must be between {min} and {max}")
    private  String password;

}
