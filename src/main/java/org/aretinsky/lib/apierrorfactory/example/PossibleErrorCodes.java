package org.aretinsky.lib.apierrorfactory.example;

import org.aretinsky.lib.apierrorfactory.example.app.error.BusinessErrorCode;
import org.aretinsky.lib.apierrorfactory.example.app.error.InvocationErrorCode;
import org.aretinsky.lib.apierrorfactory.example.app.error.SecurityErrorCode;
import org.aretinsky.lib.apierrorfactory.example.app.error.ValidationErrorCode;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PossibleErrorCodes {

    BusinessErrorCode[] business() default {};

    ValidationErrorCode[] validation() default {};

    SecurityErrorCode[] security() default {};

    InvocationErrorCode[] invocation() default {};

}