package com.keresman.service;

import com.keresman.dao.UserRepository;
import com.keresman.model.User;
import com.keresman.payload.UserLoginReq;
import com.keresman.utilities.BCryptUtils;
import com.keresman.validator.ValidationResult;
import com.keresman.validator.Validator;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserLoginService {

    private static final Logger LOGGER = Logger.getLogger(UserLoginService.class.getName());

    private final UserRepository userRepository;
    private final Validator<UserLoginReq> validator;

    public UserLoginService(UserRepository userRepository, Validator<UserLoginReq> validator) {
        this.userRepository = userRepository;
        this.validator = validator;
    }

    public ValidationResult login(UserLoginReq userLoginReq) {
        ValidationResult validation = validator.validate(userLoginReq);

        if (!validation.isSuccess()) {
            return validation;
        }

        return loginUser(userLoginReq);
    }

    private ValidationResult loginUser(UserLoginReq userLoginReq) {
        try {
            Optional<User> optionalUser = userRepository.findByUsername(userLoginReq.username());

            if (optionalUser.isEmpty()) {
                return ValidationResult.error("User not found.");
            }

            User user = optionalUser.get();
            if (!BCryptUtils.veriftyPassword(userLoginReq.password(), user.getPasswordHash())) {
                return ValidationResult.error("Invalid password.");
            }

            return ValidationResult.success(user);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Login error", e);
            return ValidationResult.error("Login failed. Please try again.");
        }
    }
}
