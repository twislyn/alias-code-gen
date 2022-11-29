package com.aliaszen.code.gen.service;

import com.aliaszen.code.gen.dto.JdbcParam;
import com.aliaszen.code.gen.dto.JdbcInfo;

/**
 * 数据库 服务类
 *
 * @author Alias Zen
 * @version 1.0
 * @since 2022-11-27
 */
public interface DbService {

    JdbcInfo createMySqlJdbcInfo(JdbcParam jdbcParam);

    JdbcInfo createPostgreSqlJdbcInfo(JdbcParam jdbcParam);

    JdbcInfo createOracleJdbcInfo(JdbcParam jdbcParam);

    JdbcInfo createSqlServerJdbcInfo(JdbcParam jdbcParam);
}
