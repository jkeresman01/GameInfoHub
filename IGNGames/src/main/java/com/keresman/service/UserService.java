package com.keresman.service;

import com.keresman.dao.UserRepository;
import com.keresman.model.User;
import com.keresman.payload.UserUpdateReq;
import com.keresman.validator.Result;
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

    public Result<Void> updateUserById(int id, UserUpdateReq userUpdateReq) {
        try {
            Optional<User> optUser = userRepository.findById(id);

            if (optUser.isEmpty()) {
                return Result.error("Can't update the user with id: %s".formatted(id));
            }

            User user = optUser.get();

            boolean hasUpdates = false;

            if (userUpdateReq.firstName() != null
                    && !userUpdateReq.firstName().isBlank()
                    && !userUpdateReq.firstName().equals(user.getFirstName())) {
                user.setFirstName(userUpdateReq.firstName());
                hasUpdates = true;
            }

            if (userUpdateReq.lastName() != null
                    && !userUpdateReq.lastName().isBlank()
                    && !userUpdateReq.lastName().equals(user.getLastName())) {
                user.setLastName(userUpdateReq.lastName());
                hasUpdates = true;
            }

            if (userUpdateReq.username() != null
                    && !userUpdateReq.username().isBlank()
                    && !userUpdateReq.username().equals(user.getUsername())) {
                user.setUsername(userUpdateReq.username());
                hasUpdates = true;
            }

            if (userUpdateReq.email() != null
                    && !userUpdateReq.email().isBlank()
                    && !userUpdateReq.email().equals(user.getEmail())) {
                user.setEmail(userUpdateReq.email());
                hasUpdates = true;
            }

//            if (updateProfileReq.gender() != null
//                    && !updateProfileReq.gender().equals(user.getGender())) {
//                user.setGender(updateProfileReq.gender());
//                hasUpdates = true;
//            }
            if (!hasUpdates) {
                return Result.error("No changes detected.");
            }

            userRepository.updateById(user.getUserId(), user);
            return Result.success();

        } catch (Exception e) {
            return Result.error("Failed to update user profile.");
        }
    }
}
