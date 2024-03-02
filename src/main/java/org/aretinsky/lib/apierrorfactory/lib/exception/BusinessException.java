package org.aretinsky.lib.apierrorfactory.lib.exception;

import org.aretinsky.lib.apierrorfactory.lib.ErrorType;
import org.aretinsky.lib.apierrorfactory.lib.code.ErrorCode;
import org.aretinsky.lib.apierrorfactory.lib.error.BusinessError;
import org.aretinsky.lib.apierrorfactory.lib.operation.OperationCode;

public class BusinessException extends ErrorException implements BusinessError {

    private final ErrorCode<BusinessError> code;

    public BusinessException(ErrorCode<BusinessError> code, OperationCode operationCode,
                             String message, Throwable cause, boolean writableStackTrace) {
        super(operationCode, message, cause, writableStackTrace);
        this.code = code;
    }

    @Override
    public ErrorType getType() {
        return ErrorType.BUSINESS;
    }

    @Override
    public ErrorCode<BusinessError> getCode() {
        return code;
    }

}