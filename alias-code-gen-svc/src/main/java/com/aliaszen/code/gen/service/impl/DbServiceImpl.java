package com.aliaszen.code.gen.service.impl;

import com.aliaszen.code.gen.dto.JdbcParam;
import com.aliaszen.code.gen.service.DbService;
import org.springframework.stereotype.Service;

/**
 * 数据库 服务实现类
 *
 * @author Alias Zen
 * @version 1.0
 * @since 2022-11-27
 */
@Service
public class DbServiceImpl implements DbService {

    @Override
    public String createMySqlJdbcUrl(JdbcParam jdbcParam) {
        return String.format("jdbc:mysql://%s/%s", jdbcParam.getHost(), jdbcParam.getDbName());
    }

    @Override
    public String createPostgreSqlJdbcUrl(JdbcParam jdbcParam) {
        return String.format("jdbc:postgresql://%s/%s", jdbcParam.getHost(), jdbcParam.getDbName());
    }

    @Override
    public String createOracleJdbcUrl(JdbcParam jdbcParam) {
        return String.format("jdbc:oracle:thin:@//%s/%s", jdbcParam.getHost(), jdbcParam.getDbName());
    }

    @Override
    public String createSqlServerJdbcUrl(JdbcParam jdbcParam) {
        return String.format("jdbc:sqlserver://%s;databaseName=%s", jdbcParam.getHost(), jdbcParam.getDbName());
    }
}
