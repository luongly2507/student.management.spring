package student.management.spring.app.services;

import student.management.spring.app.dto.UserSignUpRequest;
import student.management.spring.app.entities.User;

public interface UserService {
    public User registerUser(UserSignUpRequest userSignUp);
}
