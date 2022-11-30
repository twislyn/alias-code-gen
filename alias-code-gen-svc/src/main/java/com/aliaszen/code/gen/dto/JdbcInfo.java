package com.aliaszen.code.gen.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 数据库连接参数
 *
 * @author Alias Zen
 * @version 1.0
 * @since 2022-11-28
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class JdbcInfo {

    private String url;

    private String sql;

    private List<Object> sqlArgs;
}
