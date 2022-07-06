package com.example.authservice.service;


import com.example.authservice.dto.UserCreateDTO;
import com.example.authservice.dto.UserViewDTO;
import com.example.authservice.model.User;
import com.example.authservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserViewDTO createUser(UserCreateDTO userCreateDTO) {
        final User user = userRepository
                .save(new User(userCreateDTO.getUserName(),userCreateDTO.getFirstName(),userCreateDTO.getLastName()));
        return UserViewDTO.of(user);
    }

}
