package com.keresman.validator;

@FunctionalInterface
public interface Validator <T> {
    ValidationResult validate(T input);
}
