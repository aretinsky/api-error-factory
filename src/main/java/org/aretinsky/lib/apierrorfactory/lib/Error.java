package org.aretinsky.lib.apierrorfactory.lib;

import org.aretinsky.lib.apierrorfactory.lib.operation.OperationCode;

public interface Error {

    ErrorType getType();

    OperationCode getOperationCode();

}
