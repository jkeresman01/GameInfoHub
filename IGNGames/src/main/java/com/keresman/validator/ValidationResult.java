package com.keresman.validator;

public class ValidationResult {

    private final boolean valid;
    private final String message;

    public static ValidationResult success() {
        return new ValidationResult(true, null);
    }

    public static ValidationResult error(String message) {
        return new ValidationResult(false, message);
    }

    private ValidationResult(boolean valid, String message) {
        this.valid = valid;
        this.message = message;
    }

    public boolean isSuccess() {
        return valid;
    }

    public String getMessage() {
        return message;
    }
}
