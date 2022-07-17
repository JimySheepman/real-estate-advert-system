package com.example.authservice.mapper;

import com.example.authservice.dto.CreateUserRequestModel;
import com.example.authservice.dto.UserResponseModel;
import com.example.authservice.models.Role;
import com.example.authservice.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserModelMapper {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

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

    public User toUser(CreateUserRequestModel createUserRequestModel, Role role){
        return User.builder()
                .name(createUserRequestModel.getName())
                .surname(createUserRequestModel.getSurname())
                .username(createUserRequestModel.getUsername())
                .password(bCryptPasswordEncoder.encode(createUserRequestModel.getPassword()))
                .phoneNumber(createUserRequestModel.getPhoneNumber())
                .email(createUserRequestModel.getEmail())
                .role(role)
                .build();
    }
}
