package com.keresman.model;

public enum Role {
    ADMIN,
    USER;

    public static Role from(String roleName) {
        return Role.valueOf(roleName.toUpperCase());
    }
}
