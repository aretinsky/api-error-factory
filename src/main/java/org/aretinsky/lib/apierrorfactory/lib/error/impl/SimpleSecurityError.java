package org.aretinsky.lib.apierrorfactory.lib.error.impl;

import org.aretinsky.lib.apierrorfactory.lib.code.ErrorCode;
import org.aretinsky.lib.apierrorfactory.lib.error.BusinessError;
import org.aretinsky.lib.apierrorfactory.lib.error.SecurityError;
import org.aretinsky.lib.apierrorfactory.lib.operation.OperationCode;

public class SimpleSecurityError implements SecurityError {

    OperationCode operationCode;
    ErrorCode<SecurityError> code;

    public SimpleSecurityError(OperationCode operationCode, ErrorCode<SecurityError> code) {
        this.operationCode = operationCode;
        this.code = code;
    }

    @Override
    public OperationCode getOperationCode() {
        return operationCode;
    }

    @Override
    public ErrorCode<SecurityError> getCode() {
        return code;
    }
}