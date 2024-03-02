package org.aretinsky.lib.apierrorfactory.lib.error.impl;

import org.aretinsky.lib.apierrorfactory.lib.code.ErrorCode;
import org.aretinsky.lib.apierrorfactory.lib.error.BusinessError;
import org.aretinsky.lib.apierrorfactory.lib.error.InvocationError;
import org.aretinsky.lib.apierrorfactory.lib.operation.OperationCode;

public class SimpleInvocationError implements InvocationError {

    OperationCode operationCode;
    ErrorCode<InvocationError> code;

    public <T extends ErrorCode<?>> SimpleInvocationError(OperationCode operationCode, ErrorCode<InvocationError> code) {
        this.operationCode = operationCode;
        this.code = code;
    }

    @Override
    public OperationCode getOperationCode() {
        return operationCode;
    }

    @Override
    public ErrorCode<InvocationError> getCode() {
        return code;
    }
}
