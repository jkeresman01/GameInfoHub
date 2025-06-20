package com.keresman.service;

import com.keresman.dal.UserRepository;
import com.keresman.model.User;
import com.keresman.payload.UserUpdateReq;
import com.keresman.validator.Result;
import com.keresman.validator.Validator;
import com.keresman.validator.user.UserUpdateValidator;
import java.util.List;
import java.util.Optional;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Result<List<User>> getAllUsers() {
        try {
            List<User> users = userRepository.findAll();
            return Result.success(users);
        } catch (Exception e) {
            return Result.error("Failed to fetch users.");
        }
    }

    public Result<User> getUserById(int userId) {
        try {
            Optional<User> user = userRepository.findById(userId);
            return user.map(Result::success)
                    .orElseGet(() -> Result.error("User with ID [%d] not found.".formatted(userId)));
        } catch (Exception e) {
            return Result.error("Error fetching user with ID [%d].".formatted(userId));
        }
    }

    public Result<Void> updateUser(UserUpdateReq userUpdateReq) {
        Validator<UserUpdateReq> userValidator = new UserUpdateValidator(userRepository);

        Result<User> validationResult = userValidator.validate(userUpdateReq);

        if (!validationResult.isSuccess()) {
            return Result.error(validationResult.getMessage());
        }

        try {
            User updatedUser = validationResult.getData().get();
            userRepository.updateById(userUpdateReq.userId(), updatedUser);
            return Result.success();
        } catch (Exception e) {
            return Result.error("Failed to update user with ID: [%d]".formatted(userUpdateReq.userId()));
        }

    }
}
