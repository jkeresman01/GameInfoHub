package com.keresman.service;

import com.keresman.dao.UserRepository;
import com.keresman.payload.UserRegistrationReq;
import com.keresman.model.User;
import com.keresman.utilities.BCryptUtils;
import com.keresman.validator.Result;
import com.keresman.validator.Validator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserRegistrationService {

    private static final Logger LOGGER = Logger.getLogger(UserRegistrationService.class.getName());

    private final UserRepository userRepository;
    private final Validator<UserRegistrationReq> validator;

    public UserRegistrationService(UserRepository userRepository, Validator<UserRegistrationReq> validator) {
        this.userRepository = userRepository;
        this.validator = validator;
    }

    public Result register(UserRegistrationReq userRegistrationDTO) {
        Result validationResult = validator.validate(userRegistrationDTO);

        if (!validationResult.isSuccess()) {
            return validationResult;
        }

        return registerUser(userRegistrationDTO);
    }

    private Result registerUser(UserRegistrationReq userRegistrationReq) {
        User user = new User(
                userRegistrationReq.username(),
                BCryptUtils.hashPassword(userRegistrationReq.password()),
                userRegistrationReq.firstName(),
                userRegistrationReq.lastName(),
                userRegistrationReq.email(),
                "/assets/male_default_picture.jpg"
        );

        try {
            userRepository.save(user);
            return Result.success();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error saving user", e);
            return Result.error("Registration failed. Please try again later.");
        }
    }
}
