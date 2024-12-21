package com.yizlan.code.gen.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 数据库参数
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
public class JdbcParam {

    private String dbType;

    private String host;

    private String userName;

    private String password;

    private String dbName;
}
