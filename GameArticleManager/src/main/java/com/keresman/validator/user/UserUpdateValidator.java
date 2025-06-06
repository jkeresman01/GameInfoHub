package com.keresman.validator.user;

import com.keresman.dao.UserRepository;
import com.keresman.payload.UserUpdateReq;
import com.keresman.service.UserRegistrationService;
import com.keresman.validator.Result;
import com.keresman.validator.Validator;
import java.util.logging.Logger;

public class UserUpdateValidator implements Validator<UserUpdateReq> {

    private static final Logger LOGGER = Logger.getLogger(UserRegistrationService.class.getName());

    private final UserRepository userRepository;

    public UserUpdateValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Result validate(UserUpdateReq input) {

    }

}
