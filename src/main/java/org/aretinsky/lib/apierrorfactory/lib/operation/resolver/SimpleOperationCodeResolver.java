package org.aretinsky.lib.apierrorfactory.lib.operation.resolver;

import org.aretinsky.lib.apierrorfactory.lib.operation.OperationCode;
import org.aretinsky.lib.apierrorfactory.lib.operation.resolver.OperationCodeFromNameResolver;
import org.aretinsky.lib.apierrorfactory.lib.operation.resolver.OperationCodeResolver;
import org.aretinsky.lib.apierrorfactory.lib.operation.resolver.OperationNameResolver;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnMissingBean(name = "operationCodeResolver")
public class SimpleOperationCodeResolver implements OperationCodeResolver {

    private final OperationNameResolver operationNameResolver;
    private final OperationCodeFromNameResolver operationCodeFromNameResolver;

    public SimpleOperationCodeResolver(OperationNameResolver operationNameResolver, OperationCodeFromNameResolver operationCodeFromNameResolver) {
        this.operationNameResolver = operationNameResolver;
        this.operationCodeFromNameResolver = operationCodeFromNameResolver;
    }

    @Override
    public OperationCode resolve() {
        String operationName = operationNameResolver.resolveName();
        if (operationName == null) {
            return NoOpOperationCode.INSTANCE;
        }
        return operationCodeFromNameResolver.resolve(operationName);
    }

    private enum NoOpOperationCode implements OperationCode {

        INSTANCE

        ;

        @Override
        public String getValue() {
            return "0";
        }

        @Override
        public String getName() {
            return "no op";
        }

    }

}