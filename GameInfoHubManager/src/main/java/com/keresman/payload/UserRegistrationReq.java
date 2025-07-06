package com.keresman.payload;

import com.keresman.model.Gender;

public record UserRegistrationReq(
        String username,
        String email,
        String password,
        String confirmPassword,
        String firstName,
        String lastName,
        Gender gender) {

}
