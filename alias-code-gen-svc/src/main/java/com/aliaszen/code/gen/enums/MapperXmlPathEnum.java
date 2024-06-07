package com.aliaszen.code.gen.enums;

import com.aliaszen.code.gen.constant.Constants;
import com.yizlan.gelato.core.enums.BinaryEnum;

/**
 * mapper xml enum
 *
 * @author Alias Zen
 * @version 1.0
 * @since 2023-01-05
 */
public enum MapperXmlPathEnum implements BinaryEnum<String> {
    RESOURCES(Constants.MapperXmlDir.RESOURCES, "resources目录"),
    OTHER(Constants.MapperXmlDir.OTHER, "其他目录");

    private final String value;

    private final String text;

    MapperXmlPathEnum(String value, String text) {
        this.value = value;
        this.text = text;
    }

    @Deprecated
    public String getText() {
        return text;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String getLabel() {
        return text;
    }
}
