package com.keresman.payload;

public record UserRegistrationReq(
        String username,
        String email,
        String password,
        String confirmPassword,
        String firstName,
        String lastName) {

}
