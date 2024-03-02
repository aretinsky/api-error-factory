package org.aretinsky.lib.apierrorfactory.lib.error.impl;

import org.aretinsky.lib.apierrorfactory.lib.code.ErrorCode;
import org.aretinsky.lib.apierrorfactory.lib.error.BusinessError;
import org.aretinsky.lib.apierrorfactory.lib.operation.OperationCode;

public class SimpleBusinessError implements BusinessError {

    OperationCode operationCode;
    ErrorCode<BusinessError> code;

    public SimpleBusinessError(OperationCode operationCode, ErrorCode<BusinessError> code) {
        this.operationCode = operationCode;
        this.code = code;
    }

    @Override
    public OperationCode getOperationCode() {
        return operationCode;
    }

    @Override
    public ErrorCode<BusinessError> getCode() {
        return code;
    }
}