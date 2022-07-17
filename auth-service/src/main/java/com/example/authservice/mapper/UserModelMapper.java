package com.example.authservice.mapper;

import com.example.authservice.dto.UserResponseModel;
import com.example.authservice.models.User;
import org.springframework.stereotype.Service;

@Service
public class UserModelMapper {

    public UserResponseModel toUserResponseModel(User user){
        return UserResponseModel
                .builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .username(user.getUsername())
                .phoneNumber(user.getPhoneNumber())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }
}
