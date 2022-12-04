package com.aliaszen.code.gen.service.impl;

import com.aliaszen.code.gen.dto.JdbcInfo;
import com.aliaszen.code.gen.dto.JdbcParam;
import com.aliaszen.code.gen.service.DruidService;
import com.aliaszen.code.gen.strategy.DbStrategy;
import com.alibaba.druid.util.JdbcUtils;
import com.baomidou.mybatisplus.core.toolkit.BeanUtils;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 抽象生成方法
 *
 * @author Alias Zen
 * @version 1.0
 * @since 2022-11-27
 */
public class AbstractGenerateServiceImpl {

    @Resource
    private DbStrategy dbStrategy;

    @Resource
    private DruidService druidService;

    protected <T> List<T> list(JdbcParam jdbcParam, Class<T> clazz) {
        JdbcInfo jdbcInfo = dbStrategy.createDataSourceInfo(jdbcParam);

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Map<String, Object>> mapList = new ArrayList<>();
        try {
            String driverClassName = JdbcUtils.getDriverClassName(jdbcInfo.getUrl());
            Class.forName(driverClassName);

            connection = druidService.getOrCreateConnection(driverClassName, jdbcInfo.getUrl(),
                    jdbcParam.getUserName(), jdbcParam.getPassword(), jdbcParam.getDbType());
            preparedStatement = connection.prepareStatement(jdbcInfo.getSql());

            if(!CollectionUtils.isEmpty(jdbcInfo.getSqlArgs())) {
                for (int i = 0, len = jdbcInfo.getSqlArgs().size(); i < len; i++) {
                    preparedStatement.setObject(i + 1, jdbcInfo.getSqlArgs().get(i));
                }
            }
            resultSet = preparedStatement.executeQuery();

            final ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

            while (resultSet.next()) {
                Map<String, Object> map = new HashMap<>();
                for (int i = 0, columnCount = resultSetMetaData.getColumnCount(); i < columnCount; i++) {
                    String columnLabel = resultSetMetaData.getColumnLabel(i + 1);
                    Object object = resultSet.getObject(i + 1);
                    map.put(columnLabel, object);
                }
                mapList.add(map);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(resultSet);
            JdbcUtils.close(preparedStatement);
            JdbcUtils.close(connection);
        }
        return BeanUtils.mapsToBeans(mapList, clazz);
    }
}
