package com.keresman.validator.user;

import com.keresman.dal.UserRepository;
import com.keresman.payload.UserLoginReq;
import com.keresman.validator.Result;
import com.keresman.validator.Validator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserLoginValidator implements Validator<UserLoginReq> {

  private final UserRepository userRepository;
  private static final Logger LOGGER = Logger.getLogger(UserLoginValidator.class.getName());

  public UserLoginValidator(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public Result validate(UserLoginReq userLoginReq) {
    if (isEmpty(userLoginReq.username()) || isEmpty(userLoginReq.password())) {
      return Result.error("Username and password are required.");
    }

    try {
      if (!userRepository.existsByUsername(userLoginReq.username())) {
        return Result.error("No user found with username: %s".formatted(userLoginReq.username()));
      }
    } catch (Exception e) {
      LOGGER.log(Level.SEVERE, "Error during login validation", e);
      return Result.error("Unexpected error during validation.");
    }

    return Result.success();
  }

  private boolean isEmpty(String s) {
    return s == null || s.trim().isEmpty();
  }
}
