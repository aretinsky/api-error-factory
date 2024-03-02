package org.aretinsky.lib.apierrorfactory.lib.exception.handler;

import org.aretinsky.lib.apierrorfactory.lib.ErrorFactory;
import org.aretinsky.lib.apierrorfactory.lib.exception.ErrorException;

public class ExceptionHandler {

    public static void wrap(Runnable runnable) {
        try {
            runnable.run();
        } catch (ErrorException e) {
            throw e;
        } catch (Exception e) {
            throw ErrorFactory.internalException(e);
        }
    }

}