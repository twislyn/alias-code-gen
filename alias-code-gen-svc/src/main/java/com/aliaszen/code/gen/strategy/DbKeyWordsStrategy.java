package com.aliaszen.code.gen.strategy;

import com.aliaszen.code.gen.constant.Constants;
import com.aliaszen.code.gen.service.DbKeyWordsHandlerService;
import com.baomidou.mybatisplus.generator.config.IKeyWordsHandler;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * DB关键字策略
 *
 * @author Alias Zen
 * @version 1.0
 * @since 2022-12-07
 */
@Component
public class DbKeyWordsStrategy {

    private Map<String, Supplier<IKeyWordsHandler>> dbKeyWordsHandlerMap = new HashMap<>();

    @Resource
    private DbKeyWordsHandlerService dbKeyWordsHandlerService;

    @PostConstruct
    public void dispatcherInit() {
        dbKeyWordsHandlerMap.put(Constants.DbType.MYSQL, () -> dbKeyWordsHandlerService.createMySqlKeyWordsHandler());
        dbKeyWordsHandlerMap.put(Constants.DbType.POSTGRE_SQL, () -> dbKeyWordsHandlerService.createPostgreSqlKeyWordsHandler());
    }

    public IKeyWordsHandler createHandler(String dbType) {
        Supplier<IKeyWordsHandler> supplier = dbKeyWordsHandlerMap.get(dbType);
        if (supplier != null) {
            return supplier.get();
        }
        return null;
    }
}
