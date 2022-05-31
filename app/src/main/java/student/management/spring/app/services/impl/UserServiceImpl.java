package student.management.spring.app.services.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import student.management.spring.app.dto.UserSignUpRequest;
import student.management.spring.app.entities.User;
import student.management.spring.app.mappers.UserMapper;
import student.management.spring.app.repositories.UserRepository;
import student.management.spring.app.services.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;
    
    @Autowired
    UserMapper userMapper;
    
    @Override
    public User registerUser(UserSignUpRequest userSignUp) {
        if (userRepository.findByEmail(userSignUp.getEmail()).isPresent()){
            return null;
        }
        return userRepository.save(userMapper.toUser(userSignUp));
    }
    
}
