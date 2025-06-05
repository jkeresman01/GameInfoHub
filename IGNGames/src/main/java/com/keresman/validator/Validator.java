package com.keresman.validator;

@FunctionalInterface
public interface Validator <T> {
    Result validate(T input);
}
