package com.aliaszen.code.gen.support;

import com.aliaszen.code.gen.exception.ServiceException;

/**
 * 断言
 *
 * @author Alias Zen
 * @version 1.0
 * @since 2022-12-10
 */
public abstract class AbstractAssert {

    public static void isTrue(boolean condition, String code, Object... args) {
        if (!condition) {
            throwException(code, args);
        }
    }

    public static void throwException(String code, Object... args) {
        throw new ServiceException(code, args);
    }
}
