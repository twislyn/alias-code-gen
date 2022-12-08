package com.aliaszen.code.gen.service;

import com.baomidou.mybatisplus.generator.config.IKeyWordsHandler;

/**
 * db关键字处理器 服务类
 *
 * @author Alias Zen
 * @version 1.0
 * @since 2022-12-07
 */
public interface DbKeyWordsHandlerService {

    IKeyWordsHandler createMySqlKeyWordsHandler();

    IKeyWordsHandler createPostgreSqlKeyWordsHandler();
}
