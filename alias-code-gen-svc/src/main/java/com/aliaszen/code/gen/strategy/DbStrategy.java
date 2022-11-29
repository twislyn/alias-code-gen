package com.aliaszen.code.gen.strategy;

import com.aliaszen.code.gen.dto.JdbcParam;
import com.aliaszen.code.gen.dto.JdbcInfo;
import com.aliaszen.code.gen.service.DbService;
import com.baomidou.mybatisplus.annotation.DbType;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * 数据库连接参数策略
 *
 * @author Alias Zen
 * @version 1.0
 * @since 2022-11-27
 */
@Component
public class DbStrategy {

    private Map<String, Function<JdbcParam, JdbcInfo>> dbParamMap = new HashMap<>();

    @Resource
    private DbService dbService;

    @PostConstruct
    public void dispatcherInit() {
        dbParamMap.put(DbType.MYSQL.getDb(), jdbcParam -> dbService.createMySqlJdbcInfo(jdbcParam));
        dbParamMap.put(DbType.POSTGRE_SQL.getDb(), jdbcParam -> dbService.createPostgreSqlJdbcInfo(jdbcParam));
        dbParamMap.put(DbType.ORACLE.getDb(), jdbcParam -> dbService.createOracleJdbcInfo(jdbcParam));
        dbParamMap.put(DbType.SQL_SERVER.getDb(), jdbcParam -> dbService.createSqlServerJdbcInfo(jdbcParam));
    }

    public JdbcInfo createDataSourceInfo(JdbcParam jdbcParam) {
        Function<JdbcParam, JdbcInfo> function = dbParamMap.get(jdbcParam.getDbType());
        if (function != null) {
            return function.apply(jdbcParam);
        }
        return null;
    }
}
