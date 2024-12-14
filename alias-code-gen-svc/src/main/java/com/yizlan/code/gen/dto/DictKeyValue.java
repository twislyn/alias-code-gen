package com.yizlan.code.gen.dto;

import com.yizlan.gelato.canonical.dictionary.BinaryDictionary;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

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
public class DictKeyValue implements BinaryDictionary<String>, Serializable {
    private static final long serialVersionUID = 1L;

    private String itemValue;

    private String itemText;

    @Override
    public String getCode() {
        return itemValue;
    }

    @Override
    public void setCode(String itemValue) {
        this.itemValue = itemValue;
    }

    @Override
    public String getName() {
        return itemText;
    }

    @Override
    public void setName(String itemText) {
        this.itemText = itemText;
    }
}
