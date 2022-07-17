package com.example.authservice.mappers;


import com.example.authservice.dto.CreateUserRequestModel;
import com.example.authservice.dto.UserResponseModel;
import com.example.authservice.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(CreateUserRequestModel createUserRequestModel);

    UserResponseModel toUserResponseModel(User user);
}
