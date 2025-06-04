package com.keresman.dto;

public record UserRegistrationDTO(
        String username,
        String email,
        String password,
        String confirmPassword,
        String firstName,
        String lastName) {

}
