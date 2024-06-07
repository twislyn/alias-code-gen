package com.aliaszen.code.gen.support;

import com.yizlan.gelato.core.support.I18nAssert;

/**
 * 断言
 *
 * @author Alias Zen
 * @version 1.0
 * @since 2022-12-10
 */
public class ServiceAssert extends I18nAssert {

    public static void isTrue(boolean condition, String code, Object... args) {
        codeAssert(!condition).throwException(code, args);
    }
}
