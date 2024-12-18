package com.yizlan.code.gen.common.dictionary;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class SystemKeyValue implements BinaryDictionary<String>, Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("itemValue")
    private String code;

    @JsonProperty("itemText")
    private String name;
}
