package org.aretinsky.lib.apierrorfactory.lib.operation.resolver;

import org.aretinsky.lib.apierrorfactory.lib.operation.OperationCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class EnumOperationCodeFromNameResolver<E extends Enum<E> & OperationCode>
        implements OperationCodeFromNameResolver {

    private final Map<String, E> byNameMap;

    private EnumOperationCodeFromNameResolver(E[] enumConstants) {
        byNameMap = new HashMap<>(enumConstants.length);
        for (E operationCode : enumConstants) {
            byNameMap.put(operationCode.getName(), operationCode);
        }
    }

    public static <E extends Enum<E> & OperationCode>
    EnumOperationCodeFromNameResolver<E> create(Class<E> enumClass) {
        return new EnumOperationCodeFromNameResolver<>(enumClass.getEnumConstants());
    }

    @Override
    public OperationCode resolve(String name) {
        return Optional.ofNullable(byNameMap.get(name)).orElseThrow(
                () -> new IllegalArgumentException("Unknown operation code: %s".formatted(name))
        );
    }

}