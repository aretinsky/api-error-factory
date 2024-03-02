package org.aretinsky.lib.apierrorfactory.lib.exception;

import org.aretinsky.lib.apierrorfactory.lib.Error;
import org.aretinsky.lib.apierrorfactory.lib.operation.OperationCode;

public abstract class ErrorException extends RuntimeException implements Error {

    private final OperationCode operationCode;

    protected ErrorException(OperationCode operationCode,
                             String message,
                             Throwable cause,
                             boolean writableStackTrace) {
        super(message, cause, false, writableStackTrace);
        this.operationCode = operationCode;
    }

    @Override
    public OperationCode getOperationCode() {
        return operationCode;
    }
}