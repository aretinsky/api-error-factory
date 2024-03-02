package org.aretinsky.lib.apierrorfactory.lib.error;

import org.aretinsky.lib.apierrorfactory.lib.CodeIdentifiedError;
import org.aretinsky.lib.apierrorfactory.lib.ErrorType;
import org.aretinsky.lib.apierrorfactory.lib.code.ErrorCode;

public interface InternalError extends CodeIdentifiedError {

    @Override
    default ErrorType getType() {
        return ErrorType.INTERNAL;
    }

    @Override
    default ErrorCode<InternalError> getCode() {
        return null;
    }
}
 