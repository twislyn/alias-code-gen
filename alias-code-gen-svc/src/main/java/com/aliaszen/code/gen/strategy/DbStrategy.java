package com.aliaszen.code.gen.strategy;

import com.aliaszen.code.gen.constant.Constants;
import com.aliaszen.code.gen.dto.JdbcParam;
import com.aliaszen.code.gen.service.DbService;
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

    private Map<String, Function<JdbcParam, String>> dbParamMap = new HashMap<>();

    @Resource
    private DbService dbService;

    @PostConstruct
    public void dispatcherInit() {
        dbParamMap.put(Constants.DbType.MYSQL, jdbcParam -> dbService.createMySqlJdbcUrl(jdbcParam));
        dbParamMap.put(Constants.DbType.POSTGRE_SQL, jdbcParam -> dbService.createPostgreSqlJdbcUrl(jdbcParam));
        dbParamMap.put(Constants.DbType.ORACLE, jdbcParam -> dbService.createOracleJdbcUrl(jdbcParam));
        dbParamMap.put(Constants.DbType.SQL_SERVER, jdbcParam -> dbService.createSqlServerJdbcUrl(jdbcParam));
    }

    public String createJdbcUrl(JdbcParam jdbcParam) {
        Function<JdbcParam, String> function = dbParamMap.get(jdbcParam.getDbType());
        if (function != null) {
            return function.apply(jdbcParam);
        }
        return null;
    }
}
