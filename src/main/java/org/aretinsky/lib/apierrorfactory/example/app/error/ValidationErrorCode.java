package org.aretinsky.lib.apierrorfactory.example.app.error;

import org.aretinsky.lib.apierrorfactory.lib.code.EnumErrorCode;

public enum ValidationErrorCode implements EnumErrorCode.Validation {

    ;

    private final String value;
    private final String message;

    ValidationErrorCode(String value, String message) {
        this.value = value;
        this.message = message;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
