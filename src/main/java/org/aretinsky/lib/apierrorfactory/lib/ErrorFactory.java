package org.aretinsky.lib.apierrorfactory.lib;

import org.aretinsky.lib.apierrorfactory.lib.code.ErrorCode;
import org.aretinsky.lib.apierrorfactory.lib.error.impl.SimpleBusinessError;
import org.aretinsky.lib.apierrorfactory.lib.error.impl.SimpleInvocationError;
import org.aretinsky.lib.apierrorfactory.lib.error.impl.SimpleSecurityError;
import org.aretinsky.lib.apierrorfactory.lib.error.impl.SimpleValidationError;
import org.aretinsky.lib.apierrorfactory.lib.exception.ErrorException;
import org.aretinsky.lib.apierrorfactory.lib.exception.ErrorExceptionBuilder;
import org.aretinsky.lib.apierrorfactory.lib.exception.InternalException;
import org.aretinsky.lib.apierrorfactory.lib.operation.OperationCode;
import org.aretinsky.lib.apierrorfactory.lib.operation.resolver.OperationCodeResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public final class ErrorFactory {

    private static OperationCodeResolver operationCodeResolver;

    @Autowired
    public ErrorFactory(OperationCodeResolver operationCodeResolver) {
        ErrorFactory.operationCodeResolver = operationCodeResolver;
    }

    public static InternalException internalException(String message) {
        return internalExceptionBuilder().message(message).build();
    }

    public static InternalException internalException(Exception e) {
        return internalExceptionBuilder().cause(e).build();
    }

    public static <T extends ErrorException & CodeIdentifiedError> T exception(ErrorCode<? super T> errorCode) {
        return ErrorFactory.<T>exception(errorCode, operationCodeResolver.resolve());
    }

    public static <T extends ErrorException & CodeIdentifiedError> T
    exception(ErrorCode<? super T> errorCode, OperationCode operationCode) {
        return ErrorFactory.<T>exceptionBuilder(errorCode, operationCode).build();
    }

    public static ErrorExceptionBuilder<InternalException> internalExceptionBuilder() {
        return internalExceptionBuilder(operationCodeResolver.resolve());
    }

    public static ErrorExceptionBuilder<InternalException> internalExceptionBuilder(OperationCode operationCode) {
        var builder = new ErrorExceptionBuilder<InternalException>(ErrorType.INTERNAL, operationCode);
        builder.setWritableStackTrace(true);
        return builder;
    }

    public static <T extends ErrorException & CodeIdentifiedError> ErrorExceptionBuilder<T>
    exceptionBuilder(ErrorCode<? super T> errorCode) {
        return ErrorFactory.<T>exceptionBuilder(errorCode, operationCodeResolver.resolve());
    }

    public static <T extends ErrorException & CodeIdentifiedError> ErrorExceptionBuilder<T>
    exceptionBuilder(ErrorCode<? super T> errorCode, OperationCode operationCode) {

        var builder = new ErrorExceptionBuilder.CodeIdentified<T>(errorCode.getErrorType(), errorCode, operationCode);
        switch (errorCode.getErrorType()) {
            case BUSINESS, VALIDATION, SECURITY -> builder.setWritableStackTrace(false);
            case INVOCATION -> builder.setWritableStackTrace(true);
        }
        return builder;
    }

    public static <T extends CodeIdentifiedError> T simple(ErrorCode<T> errorCode) {
        return simple(errorCode, operationCodeResolver.resolve());
    }

    @SuppressWarnings("unchecked")
    public static <T extends CodeIdentifiedError> T simple(ErrorCode<T> errorCode, OperationCode operationCode) {
        return (T) switch (errorCode.getErrorType()) {
            case BUSINESS -> new SimpleBusinessError(operationCode, castCode(errorCode));
            case VALIDATION -> new SimpleValidationError(operationCode, castCode(errorCode));
            case SECURITY -> new SimpleSecurityError(operationCode, castCode(errorCode));
            case INVOCATION -> new SimpleInvocationError(operationCode, castCode(errorCode));
            case INTERNAL -> throw new IllegalArgumentException("Unexpected INTERNAL type on CodeIdentifiedError");
        };
    }

    @SuppressWarnings("unchecked")
    private static <T extends ErrorCode<?>> T castCode(ErrorCode<?> errorCode) {
        return (T) errorCode;
    }

}