package org.aretinsky.lib.apierrorfactory.example.app;

import org.aretinsky.lib.apierrorfactory.lib.operation.EnumOperationCode;

public enum AppOperationCode implements EnumOperationCode {

    SIMPLE_OPERATION_NAME("01"),
    SHOW_PET_CLINICS("02")
    ;

    private final String value;

    AppOperationCode(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
