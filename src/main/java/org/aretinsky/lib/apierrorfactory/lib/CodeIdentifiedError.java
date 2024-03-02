package org.aretinsky.lib.apierrorfactory.lib;

import org.aretinsky.lib.apierrorfactory.lib.code.ErrorCode;

public interface CodeIdentifiedError extends Error {

    ErrorCode<?> getCode();
}
