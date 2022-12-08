package com.aliaszen.code.gen.service;

import com.baomidou.mybatisplus.generator.config.IDbQuery;

/**
 * Db查询 服务实现类
 *
 * @author Alias Zen
 * @version 1.0
 * @since 2022-12-07
 */
public interface DbQueryService {
    IDbQuery createMySqlQuery();

    IDbQuery createPostgreSqlQuery();

    IDbQuery createOracleQuery();

    IDbQuery createSqlServerQuery();
}
