package com.keresman.validator.user;

import com.keresman.dao.UserRepository;
import com.keresman.model.User;
import com.keresman.payload.UserUpdateReq;
import com.keresman.service.UserRegistrationService;
import com.keresman.validator.Result;
import com.keresman.validator.Validator;
import java.util.Optional;
import java.util.logging.Logger;

public class UserUpdateValidator implements Validator<UserUpdateReq> {

    private static final Logger LOGGER = Logger.getLogger(UserRegistrationService.class.getName());

    private final UserRepository userRepository;

    public UserUpdateValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Result validate(UserUpdateReq req) {

        try {
            Optional<User> optUser = userRepository.findById(req.userId());

            if (optUser.isEmpty()) {
                return Result.error("User with ID [%d] not found.".formatted(req.userId()));
            }

            User user = optUser.get();
            boolean hasUpdates = false;

            if (req.firstName() != null && !req.firstName().isBlank()
                    && !req.firstName().equals(user.getFirstName())) {
                user.setFirstName(req.firstName());
                hasUpdates = true;
            }

            if (req.lastName() != null && !req.lastName().isBlank()
                    && !req.lastName().equals(user.getLastName())) {
                user.setLastName(req.lastName());
                hasUpdates = true;
            }

            if (req.username() != null && !req.username().isBlank()
                    && !req.username().equals(user.getUsername())) {
                user.setUsername(req.username());
                hasUpdates = true;
            }

            if (req.email() != null && !req.email().isBlank()
                    && !req.email().equals(user.getEmail())) {
                user.setEmail(req.email());
                hasUpdates = true;
            }

            if (!hasUpdates) {
                return Result.error("No changes detected.");
            }

            return Result.success(user);

        } catch (Exception ex) {
            return Result.error("Unexpected error ocured while trying to update user wwith ID [%d] not found, error: %s"
                    .formatted(req.userId(), ex.getMessage()));
        }
    }

}
