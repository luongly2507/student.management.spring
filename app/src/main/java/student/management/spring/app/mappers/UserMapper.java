package student.management.spring.app.mappers;

import student.management.spring.app.dto.UserSignUpRequest;
import student.management.spring.app.entities.User;

public interface UserMapper {
    public User toUser(UserSignUpRequest userSignUpRequest);
}
