package com.aliaszen.code.gen.service.impl;

import com.aliaszen.code.gen.dto.JdbcParam;
import com.aliaszen.code.gen.dto.JdbcInfo;
import com.aliaszen.code.gen.service.DbService;
import org.springframework.stereotype.Service;

import java.util.Collections;

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
    public JdbcInfo createMySqlJdbcInfo(JdbcParam jdbcParam) {
        String url = "jdbc:mysql://" + jdbcParam.getHost() + "/" + jdbcParam.getDbName();
        String sql = "select TABLE_NAME as tableName,TABLE_COMMENT as tableComment from information_schema.`TABLES` where TABLE_SCHEMA = ?";
        return JdbcInfo.builder().url(url).driverName("com.mysql.jdbc.Driver").sql(sql).sqlArgs(Collections.singletonList(jdbcParam.getDbName())).build();
    }

    @Override
    public JdbcInfo createPostgreSqlJdbcInfo(JdbcParam jdbcParam) {
        return null;
    }

    @Override
    public JdbcInfo createOracleJdbcInfo(JdbcParam jdbcParam) {
        return null;
    }

    @Override
    public JdbcInfo createSqlServerJdbcInfo(JdbcParam jdbcParam) {
        return null;
    }
}
