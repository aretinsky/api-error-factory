package org.aretinsky.lib.apierrorfactory.lib.error.impl;

import org.aretinsky.lib.apierrorfactory.lib.code.ErrorCode;
import org.aretinsky.lib.apierrorfactory.lib.error.BusinessError;
import org.aretinsky.lib.apierrorfactory.lib.error.SecurityError;
import org.aretinsky.lib.apierrorfactory.lib.error.ValidationError;
import org.aretinsky.lib.apierrorfactory.lib.operation.OperationCode;

public class SimpleValidationError implements ValidationError {

    OperationCode operationCode;
    ErrorCode<ValidationError> code;

    public SimpleValidationError(OperationCode operationCode, ErrorCode<ValidationError> code) {
        this.operationCode = operationCode;
        this.code = code;
    }

    @Override
    public OperationCode getOperationCode() {
        return operationCode;
    }

    @Override
    public ErrorCode<ValidationError> getCode() {
        return code;
    }
}
