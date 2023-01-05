package com.aliaszen.code.gen.enums;

import java.io.Serializable;

/**
 * code enum interface
 *
 * @author Alias Zen
 * @version 1.0
 * @since 2023-01-05
 */
public interface CodeEnum<T extends Serializable> {

    T getValue();
}
