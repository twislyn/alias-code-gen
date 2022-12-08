package com.aliaszen.code.gen.service;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * 数据库连接池 服务类
 *
 * @author Alias Zen
 * @version 1.0
 * @since 2022-11-30
 */
public interface DruidService {

    DruidDataSource initDataSource(String driver, String url, String userName, String password, String dbType) throws Exception;
}
