package student.management.spring.app.mappers.impl;

import java.util.Arrays;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import student.management.spring.app.dto.UserSignUpRequest;
import student.management.spring.app.entities.User;
import student.management.spring.app.mappers.UserMapper;
import student.management.spring.app.repositories.RoleRepository;

@Component
@Transactional
public class UserMapperImpl implements UserMapper{

    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Override
    public User toUser(UserSignUpRequest userSignUpRequest) {
        User user = User.builder()
                .email(userSignUpRequest.getEmail())
                .fullName(userSignUpRequest.getFullName())
                .password(passwordEncoder.encode(userSignUpRequest.getPassword()))
                .roles(Arrays.asList(roleRepository.findByName("ROLE_USER").get()))
                .build();
        return user;
    }
    
}
