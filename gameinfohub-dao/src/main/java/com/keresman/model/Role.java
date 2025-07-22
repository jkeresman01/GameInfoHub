package com.keresman.model;

public enum Role {
  ADMINISTRATOR,
  USER;

  public static Role from(String roleName) {
    return Role.valueOf(roleName.toUpperCase());
  }
}
