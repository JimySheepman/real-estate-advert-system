package com.example.authservice.services;

import com.example.authservice.dto.CreateUserRequestModel;
import com.example.authservice.dto.UserResponseModel;
import com.example.authservice.mapper.UserModelMapper;
import com.example.authservice.models.Role;
import com.example.authservice.models.User;
import com.example.authservice.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final UserModelMapper userModelMapper;

    @Override
    public UserResponseModel save(CreateUserRequestModel createUserRequestModel, Role role) {

        User user = User.builder()
                .name(createUserRequestModel.getName())
                .surname(createUserRequestModel.getSurname())
                .username(createUserRequestModel.getUsername())
                .password(bCryptPasswordEncoder.encode(createUserRequestModel.getPassword()))
                .phoneNumber(createUserRequestModel.getPhoneNumber())
                .email(createUserRequestModel.getEmail())
                .role(role)
                .build();

        User createdUser = userRepository.save(user);
        return userModelMapper.toUserResponseModel(createdUser);

    }

    @Override
    public User get(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<UserResponseModel> list() {
        return userRepository
                .findAll()
                .stream()
                .map(userModelMapper::toUserResponseModel)
                .collect(Collectors.toList());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().toString()));

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }
}
