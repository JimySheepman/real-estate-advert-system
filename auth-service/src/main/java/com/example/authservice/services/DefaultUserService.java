package com.example.authservice.services;

import com.example.authservice.dto.CreateUserRequestModel;
import com.example.authservice.mappers.UserMapper;
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

@RequiredArgsConstructor
@Service
@Transactional
public class DefaultUserService implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    // private final UserMapper userMapper;
    @Override
    public User save(CreateUserRequestModel createUserRequestModel, Role role) {

        // User user = userMapper.toUser(createUserRequestModel);
        User user = new User();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRole(role);

        return userRepository.save(user);
    }

    @Override
    public User get(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> list() {
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null){
            throw  new UsernameNotFoundException("User not found");
        }

        ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().toString()));


return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
    }
}
