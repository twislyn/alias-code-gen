package com.yizlan.code.gen.enums;

import com.baomidou.mybatisplus.annotation.DbType;
import com.yizlan.gelato.core.enums.BinaryEnum;

/**
 * db type enum
 *
 * @author Alias Zen
 * @version 1.0
 * @since 2023-01-05
 */
public enum DbTypeEnum implements BinaryEnum<String> {
    /**
     * MYSQL
     */
    MYSQL(DbType.MYSQL.getDb(), DbType.MYSQL.getDesc()),
    /**
     * MARIADB
     */
    MARIADB(DbType.MARIADB.getDb(), DbType.MARIADB.getDesc()),
    /**
     * ORACLE
     */
    ORACLE(DbType.ORACLE.getDb(), "Oracle数据库"),
    /**
     * DB2
     */
    DB2(DbType.DB2.getDb(), DbType.DB2.getDesc()),
    /**
     * H2
     */
    H2(DbType.H2.getDb(), DbType.H2.getDesc()),
    /**
     * SQLITE
     */
    SQLITE(DbType.SQLITE.getDb(), DbType.SQLITE.getDesc()),
    /**
     * POSTGRE
     */
    POSTGRE_SQL(DbType.POSTGRE_SQL.getDb(), DbType.POSTGRE_SQL.getDesc()),
    /**
     * SQLSERVER
     */
    SQL_SERVER(DbType.SQL_SERVER.getDb(), DbType.SQL_SERVER.getDesc()),
    /**
     * DM
     */
    DM(DbType.DM.getDb(), DbType.DM.getDesc()),
    /**
     * xugu
     */
    XU_GU(DbType.XU_GU.getDb(), DbType.XU_GU.getDesc()),
    /**
     * Kingbase
     */
    KINGBASE_ES(DbType.KINGBASE_ES.getDb(), DbType.KINGBASE_ES.getDesc()),
    /**
     * Gauss
     */
    GAUSS(DbType.GAUSS.getDb(), DbType.GAUSS.getDesc()),
    /**
     * ClickHouse
     */
    CLICK_HOUSE(DbType.CLICK_HOUSE.getDb(), DbType.CLICK_HOUSE.getDesc()),
    /**
     * GBase
     */
    GBASE(DbType.GBASE.getDb(), DbType.GBASE.getDesc()),
    /**
     * Oscar
     */
    OSCAR(DbType.OSCAR.getDb(), DbType.OSCAR.getDesc()),
    /**
     * Sybase
     */
    SYBASE(DbType.SYBASE.getDb(), DbType.SYBASE.getDesc()),
    /**
     * Firebird
     */
    FIREBIRD(DbType.FIREBIRD.getDb(), DbType.FIREBIRD.getDesc());

    private final String value;

    private final String text;

    DbTypeEnum(String value, String text) {
        this.value = value;
        this.text = text;
    }

    @Deprecated
    public String getText() {
        return text;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String getLabel() {
        return text;
    }
}
