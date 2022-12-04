package com.aliaszen.code.gen.service.impl;

import com.aliaszen.code.gen.dto.JdbcParam;
import com.aliaszen.code.gen.dto.JdbcInfo;
import com.aliaszen.code.gen.service.DbService;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * 数据库 服务实现类
 *
 * @author Alias Zen
 * @version 1.0
 * @since 2022-11-27
 */
@Service
public class DbServiceImpl implements DbService {

    @Override
    public JdbcInfo createMySqlJdbcInfo(JdbcParam jdbcParam) {
        String url = "jdbc:mysql://" + jdbcParam.getHost() + "/" + jdbcParam.getDbName();
        String sql = "select TABLE_NAME AS tableName,TABLE_COMMENT AS tableComment from information_schema.`TABLES` where TABLE_SCHEMA = ?";
        return JdbcInfo.builder().url(url).sql(sql).sqlArgs(Collections.singletonList(jdbcParam.getDbName())).build();
    }

    @Override
    public JdbcInfo createPostgreSqlJdbcInfo(JdbcParam jdbcParam) {
        String url = "jdbc:postgresql://" + jdbcParam.getHost() + "/" + jdbcParam.getDbName();
        String sql = "select relname AS \"tableName\",cast(obj_description(relfilenode,'pg_class') as varchar) AS \"tableComment\" from pg_class c where relkind = 'r' and relname not like 'pg_%' and relname not like 'sql_%' order by relname";
        return JdbcInfo.builder().url(url).sql(sql).build();
    }

    @Override
    public JdbcInfo createOracleJdbcInfo(JdbcParam jdbcParam) {
        String url = "jdbc:oracle:thin:@" + jdbcParam.getHost() + ":" + jdbcParam.getDbName();
        String sql = "select t1.table_name AS \"tableName\", nvl(t2.comments,'') AS \"tableComment\" from user_tables t1 inner join user_tab_comments t2 on t1.table_name = t2.table_name";
        return JdbcInfo.builder().url(url).sql(sql).build();
    }

    @Override
    public JdbcInfo createSqlServerJdbcInfo(JdbcParam jdbcParam) {
        String url = "jdbc:sqlserver://" + jdbcParam.getHost() + ";DatabaseName=" + jdbcParam.getDbName();
        String sql = "select a.name AS \"tableName\", CONVERT(NVARCHAR(100),isnull(g.[value],'')) AS \"tableComment\" from sys.tables a left join sys.extended_properties g on a.object_id = g.major_id AND g.minor_id = 0";
        return JdbcInfo.builder().url(url).sql(sql).build();
    }
}
