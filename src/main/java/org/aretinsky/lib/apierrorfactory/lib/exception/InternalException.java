package org.aretinsky.lib.apierrorfactory.lib.exception;

import org.aretinsky.lib.apierrorfactory.lib.ErrorType;
import org.aretinsky.lib.apierrorfactory.lib.code.ErrorCode;
import org.aretinsky.lib.apierrorfactory.lib.error.InternalError;
import org.aretinsky.lib.apierrorfactory.lib.operation.OperationCode;

public class InternalException extends ErrorException implements InternalError {

    public InternalException(OperationCode operationCode,
                             String message,
                             Throwable cause,
                             boolean writableStackTrace) {
        super(operationCode, message, cause, writableStackTrace);
    }

    @Override
    public ErrorType getType() {
        return ErrorType.INTERNAL;
    }

}