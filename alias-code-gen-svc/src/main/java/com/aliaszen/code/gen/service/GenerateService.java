package com.aliaszen.code.gen.service;

import com.aliaszen.code.gen.dto.JdbcParam;
import com.aliaszen.code.gen.dto.DictKeyValue;
import com.aliaszen.code.gen.dto.TableInfo;

import java.util.List;

/**
 * 生成代码 服务类
 *
 * @author Alias Zen
 * @version 1.0
 * @since 2022-11-24
 */
public interface GenerateService {

    List<DictKeyValue> getDbType();

    List<TableInfo> getTableList(JdbcParam jdbcParam);
}
