package org.aretinsky.lib.apierrorfactory.example.app.error;

import org.aretinsky.lib.apierrorfactory.lib.code.EnumErrorCode;

public enum InvocationErrorCode implements EnumErrorCode.Invocation {

    FIND_PET_CLINIC("01", "Error message for FIND_PET_CLINIC error code")
    ;

    private final String value;
    private final String message;

    InvocationErrorCode(String value, String message) {
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
