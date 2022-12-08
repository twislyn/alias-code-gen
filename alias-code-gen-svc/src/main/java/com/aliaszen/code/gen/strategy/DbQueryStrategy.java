package com.aliaszen.code.gen.strategy;

import com.aliaszen.code.gen.constant.Constants;
import com.aliaszen.code.gen.service.DbQueryService;
import com.baomidou.mybatisplus.generator.config.IDbQuery;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * DB查询策略
 *
 * @author Alias Zen
 * @version 1.0
 * @since 2022-12-07
 */
@Component
public class DbQueryStrategy {

    private Map<String, Supplier<IDbQuery>> dbQueryMap = new HashMap<>();

    @Resource
    private DbQueryService dbQueryService;

    @PostConstruct
    public void dispatcherInit() {
        dbQueryMap.put(Constants.DbType.MYSQL, () -> dbQueryService.createMySqlQuery());
        dbQueryMap.put(Constants.DbType.POSTGRE_SQL, () -> dbQueryService.createPostgreSqlQuery());
        dbQueryMap.put(Constants.DbType.ORACLE, () -> dbQueryService.createOracleQuery());
        dbQueryMap.put(Constants.DbType.SQL_SERVER, () -> dbQueryService.createSqlServerQuery());
    }

    public IDbQuery createDbQuery(String dbType) {
        Supplier<IDbQuery> supplier = dbQueryMap.get(dbType);
        if (supplier != null) {
            return supplier.get();
        }
        return null;
    }
}
