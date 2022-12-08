package com.aliaszen.code.gen.service.impl;

import com.aliaszen.code.gen.service.DbQueryService;
import com.baomidou.mybatisplus.generator.config.IDbQuery;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;
import com.baomidou.mybatisplus.generator.config.querys.OracleQuery;
import com.baomidou.mybatisplus.generator.config.querys.PostgreSqlQuery;
import com.baomidou.mybatisplus.generator.config.querys.SqlServerQuery;
import org.springframework.stereotype.Service;

/**
 * Db查询 服务类
 *
 * @author Alias Zen
 * @version 1.0
 * @since 2022-12-07
 */
@Service
public class DbQueryServiceImpl implements DbQueryService {

    @Override
    public IDbQuery createMySqlQuery() {
        return new MySqlQuery();
    }

    @Override
    public IDbQuery createPostgreSqlQuery() {
        return new PostgreSqlQuery();
    }

    @Override
    public IDbQuery createOracleQuery() {
        return new OracleQuery();
    }

    @Override
    public IDbQuery createSqlServerQuery() {
        return new SqlServerQuery();
    }
}
