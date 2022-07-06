package com.example.authservice.dto;

import com.example.authservice.model.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public final class UserViewDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String userName;
    private final String firstName;
    private final String lastName;

    private UserViewDTO(String userName,String firstName, String lastName) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static UserViewDTO of(User user){
        return new UserViewDTO(user.getUserName(),user.getFirstName(), user.getLastName());
    }
}