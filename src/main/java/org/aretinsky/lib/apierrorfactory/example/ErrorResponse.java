package org.aretinsky.lib.apierrorfactory.example;

import org.aretinsky.lib.apierrorfactory.lib.ErrorType;

public record ErrorResponse(
        ErrorType errorType,
        ErrorCodeResponse errorCodeResponse,
        String message
) {

    public record ErrorCodeResponse(
            String name,
            String value
    ) {}
}
