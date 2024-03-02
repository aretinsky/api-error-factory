package org.aretinsky.lib.apierrorfactory.lib.exception;

import org.aretinsky.lib.apierrorfactory.lib.ErrorType;
import org.aretinsky.lib.apierrorfactory.lib.code.ErrorCode;
import org.aretinsky.lib.apierrorfactory.lib.error.SecurityError;
import org.aretinsky.lib.apierrorfactory.lib.operation.OperationCode;

public class SecurityException extends ErrorException implements SecurityError {

    private final ErrorCode<SecurityError> code;

    public SecurityException(ErrorCode<SecurityError> code,
                             OperationCode operationCode,
                             String message,
                             Throwable cause,
                             boolean writableStackTrace) {
        super(operationCode, message, cause, writableStackTrace);
        this.code = code;
    }

    @Override
    public ErrorType getType() {
        return ErrorType.SECURITY;
    }

    @Override
    public ErrorCode<SecurityError> getCode() {
        return code;
    }

}