package org.aretinsky.lib.apierrorfactory.lib.error;

import org.aretinsky.lib.apierrorfactory.lib.CodeIdentifiedError;
import org.aretinsky.lib.apierrorfactory.lib.code.ErrorCode;
import org.aretinsky.lib.apierrorfactory.lib.ErrorType;

public interface InvocationError extends CodeIdentifiedError {

    @Override
    default ErrorType getType() {
        return ErrorType.INVOCATION;
    }

    @Override
    ErrorCode<InvocationError> getCode();
}
