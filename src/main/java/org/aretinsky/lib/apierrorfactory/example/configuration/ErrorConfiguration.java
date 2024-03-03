package org.aretinsky.lib.apierrorfactory.example.configuration;

import org.aretinsky.lib.apierrorfactory.example.PossibleErrorCodes;
import org.aretinsky.lib.apierrorfactory.example.app.AppOperationCode;
import org.aretinsky.lib.apierrorfactory.lib.operation.resolver.EnumOperationCodeFromNameResolver;
import org.aretinsky.lib.apierrorfactory.lib.operation.resolver.OperationCodeFromNameResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.Annotation;

@Configuration
public class ErrorConfiguration {

    @Bean
    public OperationCodeFromNameResolver operationCodeFromNameResolver() {
        return EnumOperationCodeFromNameResolver.create(AppOperationCode.class);
    }

    @Bean
    public Class<? extends Annotation> possibleErrorCodesAnnotationClass() {
        return PossibleErrorCodes.class;
    }

}