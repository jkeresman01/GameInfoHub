package com.keresman.service;

import com.keresman.dao.UserRepository;
import com.keresman.model.User;
import com.keresman.payload.UserUpdateReq;
import com.keresman.validator.ValidationResult;
import java.util.Optional;

public class UserService {
    
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ValidationResult<Void> updateUserById(int id, UserUpdateReq updateProfileReq) {
        try {
            Optional<User> optUser = userRepository.findById(id);
            
            if (optUser.isEmpty()) {
                return ValidationResult.error("Can't update the user with id: %s".formatted(id));
            }

            User user = optUser.get();
            
            boolean hasUpdates = false;

            if (updateProfileReq.firstName() != null
                    && !updateProfileReq.firstName().isBlank()
                    && !updateProfileReq.firstName().equals(user.getFirstName())) {
                user.setFirstName(updateProfileReq.firstName());
                hasUpdates = true;
            }

            if (updateProfileReq.lastName() != null
                    && !updateProfileReq.lastName().isBlank()
                    && !updateProfileReq.lastName().equals(user.getLastName())) {
                user.setLastName(updateProfileReq.lastName());
                hasUpdates = true;
            }

            if (updateProfileReq.username() != null
                    && !updateProfileReq.username().isBlank()
                    && !updateProfileReq.username().equals(user.getUsername())) {
                user.setUsername(updateProfileReq.username());
                hasUpdates = true;
            }

            if (updateProfileReq.email() != null
                    && !updateProfileReq.email().isBlank()
                    && !updateProfileReq.email().equals(user.getEmail())) {
                user.setEmail(updateProfileReq.email());
                hasUpdates = true;
            }

//            if (updateProfileReq.gender() != null
//                    && !updateProfileReq.gender().equals(user.getGender())) {
//                user.setGender(updateProfileReq.gender());
//                hasUpdates = true;
//            }

            if (!hasUpdates) {
                return ValidationResult.error("No changes detected.");
            }

            userRepository.updateById(user.getUserId(), user);
            return ValidationResult.success();

        } catch (Exception e) {
            return ValidationResult.error("Failed to update user profile.");
        }
    }
}
