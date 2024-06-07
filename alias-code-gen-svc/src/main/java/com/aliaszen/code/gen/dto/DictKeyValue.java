package com.aliaszen.code.gen.dto;

import com.yizlan.gelato.core.dictionary.BinaryDictionary;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 字典值
 *
 * @author Alias Zen
 * @version 1.0
 * @since 2022-11-24
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class DictKeyValue implements BinaryDictionary<String> {

    private String itemValue;

    private String itemText;

    @Override
    public void setCode(String itemValue) {
        this.itemValue = itemValue;
    }

    @Override
    public void setName(String itemText) {
        this.itemText = itemText;
    }

    @Override
    public String getCode() {
        return itemValue;
    }

    @Override
    public String getName() {
        return itemText;
    }
}
