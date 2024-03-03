package org.aretinsky.lib.apierrorfactory.example;

import org.aretinsky.lib.apierrorfactory.lib.CodeIdentifiedError;
import org.aretinsky.lib.apierrorfactory.lib.ErrorType;
import org.aretinsky.lib.apierrorfactory.lib.exception.ErrorException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ErrorHandlingRestControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ErrorException.class)
    public ResponseEntity<ErrorResponse> onErrorException(ErrorException error) {
        ErrorResponse.ErrorCodeResponse codeResponse = null;
        if (error instanceof CodeIdentifiedError codeIdentifiedError) {
            var code = codeIdentifiedError.getCode();
            codeResponse = new ErrorResponse.ErrorCodeResponse(code.getValue(), code.getName());
        }
        return ResponseEntity
                .status(resolve(error.getType()))
                .body(new ErrorResponse(error.getType(), codeResponse, error.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> onInternalException(Exception exception) {
        return ResponseEntity
                .status(resolve(ErrorType.INTERNAL))
                .body(new ErrorResponse(ErrorType.INTERNAL, null, "Internal exception"));
    }

    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
                                                             HttpStatus status, WebRequest request) {
        if (status.is4xxClientError()) {
            return ResponseEntity
                    .status(status)
                    .headers(headers)
                    .body(new ErrorResponse(ErrorType.VALIDATION, null, ex.getLocalizedMessage()));
        }
        return super.handleExceptionInternal(ex, body, headers, status, request);
    }

    private HttpStatus resolve(ErrorType errorType) {
        return switch (errorType) {
            case SECURITY -> HttpStatus.FORBIDDEN;
            case BUSINESS -> HttpStatus.UNPROCESSABLE_ENTITY;
            case VALIDATION -> HttpStatus.BAD_REQUEST;
            case INTERNAL, INVOCATION -> HttpStatus.INTERNAL_SERVER_ERROR;
        };
    }
}