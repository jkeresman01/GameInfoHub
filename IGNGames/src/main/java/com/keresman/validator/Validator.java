package com.keresman.validator;

public interface Validator <T> {
    ValidationResult validate(T input);
}
