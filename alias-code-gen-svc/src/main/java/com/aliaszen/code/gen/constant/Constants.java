package com.aliaszen.code.gen.constant;

import com.baomidou.mybatisplus.annotation.DbType;

/**
 * 固定常量
 *
 * @author Alias Zen
 * @version 1.0
 * @since 2022-12-07
 */
public interface Constants {

    /**
     * 源码目录位置
     */
    interface CodeTargetDir {
        String KOTLIN = "/src/main/kotlin";
        String JAVA = "/src/main/java";
        String RESOURCES = "/src/main/resources";
    }

    /**
     * mapper xml目录
     */
    interface MapperXmlDir {
        String RESOURCES = "resources";
        String OTHER = "other";
    }

    /**
     * 数据库类型
     */
    interface DataBaseType {
        /**
         * MySql数据库
         */
        String MYSQL = DbType.MYSQL.getDb();
        /**
         * MariaDB数据库
         */
        String MARIADB = DbType.MARIADB.getDb();
        /**
         * ORACLE
         */
        String ORACLE = DbType.ORACLE.getDb();
        /**
         * DB2数据库
         */
        String DB2 = DbType.DB2.getDb();
        /**
         * H2数据库
         */
        String H2 = DbType.H2.getDb();
        /**
         * HSQL数据库
         */
        String HSQL = DbType.HSQL.getDb();
        /**
         * SQLite数据库
         */
        String SQLITE = DbType.SQLITE.getDb();
        /**
         * Postgre数据库
         */
        String POSTGRE_SQL = DbType.POSTGRE_SQL.getDb();
        /**
         * SQLServer数据库
         */
        String SQL_SERVER = DbType.SQL_SERVER.getDb();
        /**
         * 达梦数据库
         */
        String DM = DbType.DM.getDb();
        /**
         * 虚谷数据库
         */
        String XU_GU = DbType.XU_GU.getDb();
        /**
         * 人大金仓数据库
         */
        String KINGBASE_ES = DbType.KINGBASE_ES.getDb();
        /**
         * Phoenix HBase数据库
         */
        String PHOENIX = DbType.PHOENIX.getDb();
        /**
         * Gauss 数据库
         */
        String GAUSS = DbType.GAUSS.getDb();
        /**
         * clickhouse 数据库
         */
        String CLICK_HOUSE = DbType.CLICK_HOUSE.getDb();
        /**
         * 南大通用数据库
         */
        String GBASE = DbType.GBASE.getDb();
        /**
         * 神通数据库
         */
        String OSCAR = DbType.OSCAR.getDb();
        /**
         * Sybase ASE 数据库
         */
        String SYBASE = DbType.SYBASE.getDb();
        /**
         * OceanBase 数据库
         */
        String OCEAN_BASE = DbType.OCEAN_BASE.getDb();
        /**
         * Firebird 数据库
         */
        String FIREBIRD = DbType.FIREBIRD.getDb();
        /**
         * 瀚高数据库
         */
        String HIGH_GO = DbType.HIGH_GO.getDb();
        /**
         * CUBRID数据库
         */
        String CUBRID = DbType.CUBRID.getDb();
        /**
         * GOLDILOCKS数据库
         */
        String GOLDILOCKS = DbType.GOLDILOCKS.getDb();
        /**
         * CSIIDB数据库
         */
        String CSIIDB = DbType.CSIIDB.getDb();
        /**
         * SAP_HANA数据库
         */
        String SAP_HANA = DbType.SAP_HANA.getDb();
        /**
         * impala数据库
         */
        String IMPALA = DbType.IMPALA.getDb();
        /**
         * vertica数据库
         */
        String VERTICA = DbType.VERTICA.getDb();
        /**
         * 行云数据库
         */
        String XCloud = DbType.XCloud.getDb();

        static Boolean allowGenerate(String dbType) {
            return MYSQL.equals(dbType) || POSTGRE_SQL.equals(dbType) || ORACLE.equals(dbType) || SQL_SERVER.equals(dbType);
        }

        static Boolean containDbQuery(String dbType) {
            return MYSQL.equals(dbType) || MARIADB.equals(dbType) || ORACLE.equals(dbType)

                    || DB2.equals(dbType) || H2.equals(dbType) || SQLITE.equals(dbType)

                    || POSTGRE_SQL.equals(dbType) || SQL_SERVER.equals(dbType) || DM.equals(dbType)

                    || XU_GU.equals(dbType) || KINGBASE_ES.equals(dbType) || GAUSS.equals(dbType)

                    || CLICK_HOUSE.equals(dbType) || GBASE.equals(dbType) || OSCAR.equals(dbType)

                    || SYBASE.equals(dbType) || FIREBIRD.equals(dbType);
        }

        static Boolean containDbKeywords(String dbType) {
            return MYSQL.equals(dbType) || H2.equals(dbType) || POSTGRE_SQL.equals(dbType);
        }
    }
}
