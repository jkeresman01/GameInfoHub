package com.keresman.validator;

import java.util.Optional;

public class ValidationResult<T> {

    private final boolean success;
    private final String message;
    private final T data;

    private ValidationResult(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public static <T> ValidationResult<T> success(T data) {
        return new ValidationResult<>(true, null, data);
    }

    public static <T> ValidationResult<T> success() {
        return new ValidationResult<>(true, null, null);
    }

    public static <T> ValidationResult<T> error(String message) {
        return new ValidationResult<>(false, message, null);
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public Optional<T> getData() {
        return Optional.ofNullable(data);
    }
}
