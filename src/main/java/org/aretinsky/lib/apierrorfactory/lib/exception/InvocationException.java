package org.aretinsky.lib.apierrorfactory.lib.exception;

import org.aretinsky.lib.apierrorfactory.lib.ErrorType;
import org.aretinsky.lib.apierrorfactory.lib.code.ErrorCode;
import org.aretinsky.lib.apierrorfactory.lib.error.InvocationError;
import org.aretinsky.lib.apierrorfactory.lib.operation.OperationCode;

public class InvocationException extends ErrorException implements InvocationError {

    private final ErrorCode<InvocationError> code;

    public InvocationException(ErrorCode<InvocationError> code, OperationCode operationCode,
                               String message, Throwable cause, boolean writableStackTrace) {
        super(operationCode, message, cause, writableStackTrace);
        this.code = code;
    }

    @Override
    public ErrorType getType() {
        return ErrorType.INVOCATION;
    }

    @Override
    public ErrorCode<InvocationError> getCode() {
        return code;
    }

}