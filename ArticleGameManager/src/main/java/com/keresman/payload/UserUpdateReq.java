package com.keresman.payload;

public record UserUpdateReq(
        String username,
        String email,
        String firstName,
        String lastName //        Gender gender
        ) {
}
