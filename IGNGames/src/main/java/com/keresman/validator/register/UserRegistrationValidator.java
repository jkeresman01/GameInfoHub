package com.keresman.validator.register;

import com.keresman.dao.UserRepository;
import com.keresman.payload.UserRegistrationReq;
import com.keresman.service.UserRegistrationService;
import com.keresman.validator.ValidationResult;
import com.keresman.validator.Validator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserRegistrationValidator implements Validator<UserRegistrationReq>{

    private static final Logger LOGGER = Logger.getLogger(UserRegistrationService.class.getName());

    private final UserRepository userRepository;

    public UserRegistrationValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ValidationResult validate(UserRegistrationReq userRegistrationReq) {
        if (isEmpty(userRegistrationReq.username())
                || isEmpty(userRegistrationReq.email())
                || isEmpty(userRegistrationReq.password())
                || isEmpty(userRegistrationReq.confirmPassword())) {
            return ValidationResult.error("All fields must be filled.");
        }

        try {
            if (userRepository.existsByUsername(userRegistrationReq.username())) {
                return ValidationResult.error("Username already taken.");
            }

            if (userRepository.existsByEmail(userRegistrationReq.email())) {
                return ValidationResult.error("Email already in use.");
            }

            if (!userRegistrationReq.password().equals(userRegistrationReq.confirmPassword())) {
                return ValidationResult.error("Passwords do not match.");
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Validation error", e);
            return ValidationResult.error("An error occurred during validation.");
        }

        return ValidationResult.success();
    }

    private boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}
