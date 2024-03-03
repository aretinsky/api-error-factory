package org.aretinsky.lib.apierrorfactory.lib.operation.resolver;

import org.slf4j.MDC;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnMissingBean(name = "operationNameResolver")
public class SimpleOperationNameResolver implements OperationNameResolver {

    @Override
    public String resolveName() {
        return MDC.get("operationName");
    }
}
