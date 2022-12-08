package com.aliaszen.code.gen.service;

import com.aliaszen.code.gen.dto.JdbcParam;

/**
 * 数据库 服务类
 *
 * @author Alias Zen
 * @version 1.0
 * @since 2022-11-27
 */
public interface DbService {

    String createMySqlJdbcUrl(JdbcParam jdbcParam);

    String createPostgreSqlJdbcUrl(JdbcParam jdbcParam);

    String createOracleJdbcUrl(JdbcParam jdbcParam);

    String createSqlServerJdbcUrl(JdbcParam jdbcParam);
}
