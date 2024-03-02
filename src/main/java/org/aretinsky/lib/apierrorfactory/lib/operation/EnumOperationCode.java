package org.aretinsky.lib.apierrorfactory.lib.operation;

public interface EnumOperationCode extends OperationCode {

    String name();

    @Override
    default String getName() {
        return name();
    }

}