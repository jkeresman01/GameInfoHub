package com.keresman.payload;

public record UserUpdateReq(
        int userId,
        String username,
        String email,
        String firstName,
        String lastName) {

}
