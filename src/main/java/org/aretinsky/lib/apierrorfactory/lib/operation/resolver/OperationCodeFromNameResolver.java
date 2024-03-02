package org.aretinsky.lib.apierrorfactory.lib.operation.resolver;


import org.aretinsky.lib.apierrorfactory.lib.operation.OperationCode;

public interface OperationCodeFromNameResolver {

    OperationCode resolve(String name);

}