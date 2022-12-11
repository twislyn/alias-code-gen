package com.aliaszen.code.gen.enums;

import com.baomidou.mybatisplus.annotation.DbType;
import org.springframework.util.StringUtils;

/**
 * jdbc url正则表达式
 *
 * @author Alias Zen
 * @version 1.0
 * @since 2022-12-08
 */
public enum JdbcRegularUrl {

    MYSQL(DbType.MYSQL.getDb(), "jdbc:mysql://%s/%s?useSSL=false"),
    MARIADB(DbType.MARIADB.getDb(), "jdbc:mariadb://%s/%s"),
    POSTGRESQL(DbType.POSTGRE_SQL.getDb(), "jdbc:postgresql://%s/%s"),
    ORACLE(DbType.ORACLE.getDb(), "jdbc:oracle:thin:@%s:%s"),
    MSSQL(DbType.SQL_SERVER.getDb(), "jdbc:sqlserver://%s;databaseName=%s;"),
    DB2(DbType.DB2.getDb(), "jdbc:db2://%s/%s"),
    H2(DbType.H2.getDb(), "jdbc:h2:tcp://%s/%s"),
    SQLITE(DbType.SQLITE.getDb(), "jdbc:sqlite:%s");

    private final String dbType;
    private final String urlExp;

    public String getDbType() {
        return dbType;
    }

    public String getUrlExp() {
        return urlExp;
    }

    JdbcRegularUrl(final String dbType, final String urlExp) {
        this.dbType = dbType;
        this.urlExp = urlExp;
    }

    public static String match(String dbType, Object... args) {
        if (StringUtils.hasText(dbType)) {
            for (JdbcRegularUrl jdbcRegularUrl : JdbcRegularUrl.values()) {
                if (jdbcRegularUrl.getDbType().equals(dbType)) {
                    return String.format(jdbcRegularUrl.getUrlExp(), args);
                }
            }
        }
        return null;
    }
}
