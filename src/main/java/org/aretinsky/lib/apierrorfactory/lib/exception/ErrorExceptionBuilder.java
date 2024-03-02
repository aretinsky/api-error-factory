package org.aretinsky.lib.apierrorfactory.lib.exception;

import lombok.experimental.Accessors;
import org.aretinsky.lib.apierrorfactory.lib.CodeIdentifiedError;
import org.aretinsky.lib.apierrorfactory.lib.ErrorType;
import org.aretinsky.lib.apierrorfactory.lib.code.ErrorCode;
import org.aretinsky.lib.apierrorfactory.lib.error.BusinessError;
import org.aretinsky.lib.apierrorfactory.lib.error.InvocationError;
import org.aretinsky.lib.apierrorfactory.lib.error.SecurityError;
import org.aretinsky.lib.apierrorfactory.lib.error.ValidationError;
import org.aretinsky.lib.apierrorfactory.lib.operation.OperationCode;

import java.util.ArrayList;
import java.util.List;

@Accessors(chain = true, fluent = true)
public class ErrorExceptionBuilder<T extends ErrorException> {

    protected final ErrorType errorType;
    protected final OperationCode operationCode;
    protected String message = "";
    protected List<String> args;
    protected Throwable cause;
    protected boolean writableStackTrace;

    public ErrorExceptionBuilder(ErrorType errorType, OperationCode operationCode) {
        this.errorType = errorType;
        this.operationCode = operationCode;
    }

    public ErrorExceptionBuilder<T> message(String message) {
        this.message = message != null ? message : "";
        return this;
    }

    public ErrorExceptionBuilder<T> cause(Throwable cause) {
        this.cause = cause;
        return this;
    }

    public ErrorExceptionBuilder<T> args(String... args) {
        this.args = new ArrayList<>(List.of(args));
        return this;
    }

    public ErrorExceptionBuilder<T> arg(String arg) {
        if (args == null) {
            args = new ArrayList<>(1);
        }
        args.add(arg);
        return this;
    }

    public ErrorExceptionBuilder<T> arg(String key, Object value) {
        return arg(key + "=" + value);
    }

    public T build() {
        return (T) switch (errorType) {
            case INTERNAL -> new InternalException(operationCode, compileMessage(), cause, writableStackTrace);
            default -> throw new IllegalStateException(errorType + " error should built by CodeIdentified builder");
        };
    }

    protected String compileArgs() {
        return args != null ? "'" + String.join("', '", args) + "'" : "";
    }

    protected final String compileMessage(String message) {
        String compiledArgs = compileArgs();
        if (message.isEmpty() && compiledArgs.isEmpty()) {
            return "";
        }
        if (message.isEmpty()) {
            return compiledArgs;
        }
        if (compiledArgs.isEmpty()) {
            return message;
        }
        return message + " " + compiledArgs;
    }

    protected String compileMessage() {
        return compileMessage(message);
    }

    @Accessors(chain = true, fluent = true)
    public static class CodeIdentified<T extends ErrorException & CodeIdentifiedError>
            extends ErrorExceptionBuilder<T> {

        private final ErrorCode<T> errorCode;

        public CodeIdentified(ErrorType errorType, ErrorCode<? super T> errorCode, OperationCode operationCode) {
            super(errorType, operationCode);
            this.errorCode = (ErrorCode<T>) errorCode;
        }

        @Override
        protected String compileMessage() {
            String initialMessage = !message.isEmpty() ? message
                    : errorCode != null ? errorCode.getMessage()
                    : "";
            return compileMessage(initialMessage);
        }

        public T build() {
            Creator<?> creator = switch (errorType) {
                case BUSINESS -> (Creator<BusinessError>) BusinessException::new;
                case VALIDATION -> (Creator<ValidationError>) ValidationException::new;
                case INVOCATION -> (Creator<InvocationError>) InvocationException::new;
                case SECURITY -> (Creator<SecurityError>) SecurityException::new;
                default -> throw new IllegalStateException("failed to build exception with type " + errorType);
            };
            return ((Creator<T>) creator).create(errorCode, operationCode, compileMessage(), cause, writableStackTrace);
        }

        private interface Creator<T extends CodeIdentifiedError> {

            T create(ErrorCode<T> code,
                     OperationCode operationCode,
                     String message,
                     Throwable cause,
                     boolean writableStackTrace);

        }

    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setArgs(List<String> args) {
        this.args = args;
    }

    public void setCause(Throwable cause) {
        this.cause = cause;
    }

    public void setWritableStackTrace(boolean writableStackTrace) {
        this.writableStackTrace = writableStackTrace;
    }
}