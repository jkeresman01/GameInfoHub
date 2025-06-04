package com.keresman.service;

import com.keresman.dao.UserRepository;
import com.keresman.dto.UserRegistrationDTO;
import com.keresman.model.User;
import com.keresman.utilities.BCryptUtils;
import com.keresman.validator.ValidationResult;
import com.keresman.validator.Validator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserRegistrationService {

    private static final Logger LOGGER = Logger.getLogger(UserRegistrationService.class.getName());

    private final UserRepository userRepository;
    private final Validator<UserRegistrationDTO> validator;

    public UserRegistrationService(UserRepository userRepository, Validator<UserRegistrationDTO> validator) {
        this.userRepository = userRepository;
        this.validator = validator;
    }

    public ValidationResult register(UserRegistrationDTO userRegistrationDTO) {
        ValidationResult validationResult = validator.validate(userRegistrationDTO);

        if (!validationResult.isSuccess()) {
            return validationResult;
        }

        return registerUser(userRegistrationDTO);
    }

    private ValidationResult registerUser(UserRegistrationDTO userRegistrationDTO) {
        User user = new User(
                userRegistrationDTO.username(),
                BCryptUtils.hashPassword(userRegistrationDTO.password()),
                userRegistrationDTO.firstName(),
                userRegistrationDTO.lastName(),
                userRegistrationDTO.email(),
                "assets/male_default_picture.jpg"
        );

        try {
            userRepository.save(user);
            return ValidationResult.success();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error saving user", e);
            return ValidationResult.error("Registration failed. Please try again later.");
        }
    }
}
