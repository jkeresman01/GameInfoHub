package com.keresman.model;

public enum Gender {
  MALE,
  FEMALE,
  OTHER;

  public static Gender from(String gender) {
    return Gender.valueOf(gender.toUpperCase());
  }
}
