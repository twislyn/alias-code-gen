package com.aliaszen.code.gen.service.impl;

import com.aliaszen.code.gen.dto.DictKeyValue;
import com.aliaszen.code.gen.dto.JdbcParam;
import com.aliaszen.code.gen.dto.TableInfo;
import com.aliaszen.code.gen.service.GenerateService;
import com.baomidou.mybatisplus.annotation.DbType;
import org.springframework.stereotype.Service;

import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 生成代码 服务实现类
 *
 * @author Alias Zen
 * @version 1.0
 * @since 2022-11-24
 */
@Service
public class GenerateServiceImpl extends AbstractGenerateServiceImpl implements GenerateService {

    @Override
    public List<DictKeyValue> getDbType() {
        return EnumSet.allOf(DbType.class).stream()
                .map(m -> DictKeyValue.builder().itemText(m.getDesc()).itemValue(m.getDb()).build())
                .collect(Collectors.toList());
    }

    @Override
    public List<TableInfo> getTableList(JdbcParam jdbcParam) {
        return list(jdbcParam, TableInfo.class);
    }
}
