package com.aliaszen.code.gen.constant;

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
    interface DbType {
        /**
         * MySql数据库
         */
        String MYSQL = "mysql";
        /**
         * MariaDB数据库
         */
        String MARIADB = "mariadb";
        /**
         * ORACLE
         */
        String ORACLE = "oracle";
        /**
         * DB2数据库
         */
        String DB2 = "db2";
        /**
         * H2数据库
         */
        String H2 = "h2";
        /**
         * HSQL数据库
         */
        String HSQL = "hsql";
        /**
         * SQLite数据库
         */
        String SQLITE = "sqlite";
        /**
         * Postgre数据库
         */
        String POSTGRE_SQL = "postgresql";
        /**
         * SQLServer数据库
         */
        String SQL_SERVER = "sqlserver";
        /**
         * 达梦数据库
         */
        String DM = "dm";
        /**
         * 虚谷数据库
         */
        String XU_GU = "xugu";
        /**
         * 人大金仓数据库
         */
        String KINGBASE_ES = "kingbasees";
        /**
         * Phoenix HBase数据库
         */
        String PHOENIX = "phoenix";
        /**
         * Gauss 数据库
         */
        String GAUSS = "zenith";
        /**
         * clickhouse 数据库
         */
        String CLICK_HOUSE = "clickhouse";
        /**
         * 南大通用数据库
         */
        String GBASE = "gbase";
        /**
         * 神通数据库
         */
        String OSCAR = "oscar";
        /**
         * Sybase ASE 数据库
         */
        String SYBASE = "sybase";
        /**
         * OceanBase 数据库
         */
        String OCEAN_BASE = "oceanbase";
        /**
         * Firebird 数据库
         */
        String FIREBIRD = "Firebird";
        /**
         * 瀚高数据库
         */
        String HIGH_GO = "highgo";
        /**
         * CUBRID数据库
         */
        String CUBRID = "cubrid";
        /**
         * GOLDILOCKS数据库
         */
        String GOLDILOCKS = "goldilocks";
        /**
         * CSIIDB数据库
         */
        String CSIIDB = "csiidb";
        /**
         * SAP_HANA数据库
         */
        String SAP_HANA = "hana";
        /**
         * impala数据库
         */
        String IMPALA = "impala";
        /**
         * vertica数据库
         */
        String VERTICA = "vertica";
        /**
         * 行云数据库
         */
        String XCloud = "xcloud";

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
