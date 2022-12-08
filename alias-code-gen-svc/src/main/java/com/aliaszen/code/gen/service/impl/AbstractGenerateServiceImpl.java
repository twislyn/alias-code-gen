package com.aliaszen.code.gen.service.impl;

import com.aliaszen.code.gen.dto.JdbcParam;
import com.aliaszen.code.gen.service.DruidService;
import com.aliaszen.code.gen.strategy.DbStrategy;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.util.JdbcUtils;

import javax.annotation.Resource;
import java.sql.SQLException;

/**
 * 抽象生成方法
 *
 * @author Alias Zen
 * @version 1.0
 * @since 2022-11-27
 */
public class AbstractGenerateServiceImpl {

    @Resource
    public DbStrategy dbStrategy;

    @Resource
    private DruidService druidService;

    DruidDataSource createDataSource(JdbcParam jdbcParam) {
        String jdbcUrl = dbStrategy.createJdbcUrl(jdbcParam);

        String driverClassName = null;
        try {
            driverClassName = JdbcUtils.getDriverClassName(jdbcUrl);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            return druidService.initDataSource(driverClassName, jdbcUrl, jdbcParam.getUserName(),
                    jdbcParam.getPassword(), jdbcParam.getDbType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
