package com.aliaszen.code.gen.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 项目配置
 *
 * @author Alias Zen
 * @version 1.0
 * @since 2022-12-11
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ProjectSetting {

    private List<DictKeyValue> dbTypeList;

    private List<DictKeyValue> xmlDirList;
}
