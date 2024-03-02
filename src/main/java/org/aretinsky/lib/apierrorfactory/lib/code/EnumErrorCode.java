package org.aretinsky.lib.apierrorfactory.lib.code;

import org.aretinsky.lib.apierrorfactory.lib.CodeIdentifiedError;
import org.aretinsky.lib.apierrorfactory.lib.error.BusinessError;
import org.aretinsky.lib.apierrorfactory.lib.error.InvocationError;
import org.aretinsky.lib.apierrorfactory.lib.error.SecurityError;
import org.aretinsky.lib.apierrorfactory.lib.error.ValidationError;

public interface EnumErrorCode<T extends CodeIdentifiedError> extends ErrorCode<T> {

    String name();

    @Override
    default String getName() {
        return name();
    }

    interface Business extends ErrorCode.Business, EnumErrorCode<BusinessError> {}

    interface Validation extends ErrorCode.Validation, EnumErrorCode<ValidationError> {}

    interface Invocation extends ErrorCode.Invocation, EnumErrorCode<InvocationError> {}

    interface Security extends ErrorCode.Security, EnumErrorCode<SecurityError> {}

}