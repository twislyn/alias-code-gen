package com.aliaszen.code.gen.service.impl;

import com.aliaszen.code.gen.service.DbKeyWordsHandlerService;
import com.baomidou.mybatisplus.generator.config.IKeyWordsHandler;
import com.baomidou.mybatisplus.generator.keywords.MySqlKeyWordsHandler;
import com.baomidou.mybatisplus.generator.keywords.PostgreSqlKeyWordsHandler;
import org.springframework.stereotype.Service;

/**
 * db关键字处理器 服务实现类
 *
 * @author Alias Zen
 * @version 1.0
 * @since 2022-12-07
 */
@Service
public class DbKeyWordsHandlerServiceImpl implements DbKeyWordsHandlerService {

    @Override
    public IKeyWordsHandler createMySqlKeyWordsHandler() {
        return new MySqlKeyWordsHandler();
    }

    @Override
    public IKeyWordsHandler createPostgreSqlKeyWordsHandler() {
        return new PostgreSqlKeyWordsHandler();
    }
}
