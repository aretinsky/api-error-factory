package org.aretinsky.lib.apierrorfactory.lib.code;

import org.aretinsky.lib.apierrorfactory.lib.CodeIdentifiedError;
import org.aretinsky.lib.apierrorfactory.lib.ErrorType;
import org.aretinsky.lib.apierrorfactory.lib.error.BusinessError;
import org.aretinsky.lib.apierrorfactory.lib.error.InvocationError;
import org.aretinsky.lib.apierrorfactory.lib.error.SecurityError;
import org.aretinsky.lib.apierrorfactory.lib.error.ValidationError;

public interface ErrorCode<T extends CodeIdentifiedError> {

    ErrorType getErrorType();

    String getValue();

    String getName();

    String getMessage();

    interface Business extends ErrorCode<BusinessError> {

        @Override
        default ErrorType getErrorType() {
            return ErrorType.BUSINESS;
        }

    }

    interface Validation extends ErrorCode<ValidationError> {

        @Override
        default ErrorType getErrorType() {
            return ErrorType.VALIDATION;
        }

    }

    interface Invocation extends ErrorCode<InvocationError> {

        @Override
        default ErrorType getErrorType() {
            return ErrorType.INVOCATION;
        }

    }

    interface Security extends ErrorCode<SecurityError> {

        @Override
        default ErrorType getErrorType() {
            return ErrorType.SECURITY;
        }

    }
}