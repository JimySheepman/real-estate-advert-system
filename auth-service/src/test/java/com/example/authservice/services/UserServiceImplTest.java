package com.example.authservice.services;

import com.example.authservice.dto.CreateUserRequestModel;
import com.example.authservice.mapper.UserModelMapper;
import com.example.authservice.models.Role;
import com.example.authservice.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.junit.Test;
import org.mockito.Mockito;

@RequiredArgsConstructor
public class UserServiceImplTest {
    private UserServiceImpl userService;

    private UserRepository userRepository;
    private UserModelMapper userModelMapper;

    @org.junit.Before
    public void setUp() throws Exception {
        userRepository = Mockito.mock(UserRepository.class);
        userModelMapper = Mockito.mock(UserModelMapper.class);

        userService = new UserServiceImpl(userRepository, userModelMapper);
    }

    @Test
    public void whenSaveCalledWithValidRequest_itShouldReturnValidUserResponseModel() {
        CreateUserRequestModel createUserRequestModel = CreateUserRequestModel
                .builder()
                .name("user")
                .surname("user")
                .username("user")
                .password("user")
                .phoneNumber("12345")
                .email("user@user.com")
                .build();

        Role role = Role.USER;
    }
}