package org.aretinsky.lib.apierrorfactory.lib.exception;

import org.aretinsky.lib.apierrorfactory.lib.ErrorType;
import org.aretinsky.lib.apierrorfactory.lib.code.ErrorCode;
import org.aretinsky.lib.apierrorfactory.lib.error.ValidationError;
import org.aretinsky.lib.apierrorfactory.lib.operation.OperationCode;

public class ValidationException extends ErrorException implements ValidationError {

    private final ErrorCode<ValidationError> code;

    public ValidationException(ErrorCode<ValidationError> code,
                               OperationCode operationCode,
                               String message,
                               Throwable cause,
                               boolean writableStackTrace) {
        super(operationCode, message, cause, writableStackTrace);
        this.code = code;
    }

    @Override
    public ErrorType getType() {
        return ErrorType.VALIDATION;
    }

    @Override
    public ErrorCode<ValidationError> getCode() {
        return code;
    }

}