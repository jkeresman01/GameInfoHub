package com.keresman.validator.user;

import com.keresman.dal.UserRepository;
import com.keresman.payload.UserRegistrationReq;
import com.keresman.service.UserRegistrationService;
import com.keresman.validator.Result;
import com.keresman.validator.Validator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserRegistrationValidator implements Validator<UserRegistrationReq> {

  private static final Logger LOGGER = Logger.getLogger(UserRegistrationService.class.getName());

  private final UserRepository userRepository;

  public UserRegistrationValidator(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public Result validate(UserRegistrationReq userRegistrationReq) {
    if (isEmpty(userRegistrationReq.username())
        || isEmpty(userRegistrationReq.email())
        || isEmpty(userRegistrationReq.password())
        || isEmpty(userRegistrationReq.confirmPassword())) {
      return Result.error("All fields must be filled.");
    }

    try {
      if (userRepository.existsByUsername(userRegistrationReq.username())) {
        return Result.error("Username already taken.");
      }

      if (userRepository.existsByEmail(userRegistrationReq.email())) {
        return Result.error("Email already in use.");
      }

      if (!userRegistrationReq.password().equals(userRegistrationReq.confirmPassword())) {
        return Result.error("Passwords do not match.");
      }
    } catch (Exception e) {
      LOGGER.log(Level.SEVERE, "Validation error", e);
      return Result.error("An error occurred during validation.");
    }

    return Result.success();
  }

  private boolean isEmpty(String value) {
    return value == null || value.trim().isEmpty();
  }
}
