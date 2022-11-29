package com.aliaszen.code.gen.dto;

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
public class DictKeyValue {

    private String itemValue;

    private String itemText;
}
