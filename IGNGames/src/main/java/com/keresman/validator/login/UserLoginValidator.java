package com.keresman.validator.login;

import com.keresman.dao.UserRepository;
import com.keresman.payload.UserLoginReq;
import com.keresman.validator.ValidationResult;
import com.keresman.validator.Validator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserLoginValidator implements Validator<UserLoginReq> {

    private final UserRepository userRepository;
    private static final Logger LOGGER = Logger.getLogger(UserLoginValidator.class.getName());

    public UserLoginValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ValidationResult validate(UserLoginReq userLoginReq) {
        if (isEmpty(userLoginReq.username()) || isEmpty(userLoginReq.password())) {
            return ValidationResult.error("Username and password are required.");
        }

        try {
            if (!userRepository.existsByUsername(userLoginReq.username())) {
                return ValidationResult.error("No user found with username: %s".formatted(userLoginReq.username()));
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error during login validation", e);
            return ValidationResult.error("Unexpected error during validation.");
        }

        return ValidationResult.success();
    }
    
    private boolean isEmpty(String s) {
        return s == null || s.trim().isEmpty();
    }
}
