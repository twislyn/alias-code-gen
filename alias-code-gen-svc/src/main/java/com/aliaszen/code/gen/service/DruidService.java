package com.aliaszen.code.gen.service;

import com.alibaba.druid.pool.DruidPooledConnection;

/**
 * 数据库连接池 服务类
 *
 * @author Alias Zen
 * @version 1.0
 * @since 2022-11-30
 */
public interface DruidService {

    DruidPooledConnection getOrCreateConnection(String driver, String url, String userName,
                                                String password, String dbType) throws Exception;
}
