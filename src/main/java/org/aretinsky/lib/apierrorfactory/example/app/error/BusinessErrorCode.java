package org.aretinsky.lib.apierrorfactory.example.app.error;

import org.aretinsky.lib.apierrorfactory.lib.code.EnumErrorCode;

public enum BusinessErrorCode implements EnumErrorCode.Business {

    SHOW_PET_CLINIC("01", "Error message for SHOW_PET_CLINIC error code"),
    RETRIEVE_CLINIC_BY_ID("02", "Failed to retrieve clinic by id")
    ;

    private final String value;
    private final String message;

    BusinessErrorCode(String value, String message) {
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
