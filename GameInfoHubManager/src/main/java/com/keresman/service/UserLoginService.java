package com.keresman.service;

import com.keresman.dal.UserRepository;
import com.keresman.model.User;
import com.keresman.payload.UserLoginReq;
import com.keresman.utilities.BCryptUtils;
import com.keresman.validator.Result;
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

    public Result login(UserLoginReq userLoginReq) {
        Result validation = validator.validate(userLoginReq);

        if (!validation.isSuccess()) {
            return validation;
        }

        return loginUser(userLoginReq);
    }

    private Result loginUser(UserLoginReq userLoginReq) {
        try {
            Optional<User> optionalUser = userRepository.findByUsername(userLoginReq.username());

            if (optionalUser.isEmpty()) {
                return Result.error("User not found.");
            }

            User user = optionalUser.get();
            if (!BCryptUtils.veriftyPassword(userLoginReq.password(), user.getPasswordHash())) {
                return Result.error("Invalid password.");
            }

            return Result.success(user);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Login error", e);
            return Result.error("Login failed. Please try again.");
        }
    }
}
