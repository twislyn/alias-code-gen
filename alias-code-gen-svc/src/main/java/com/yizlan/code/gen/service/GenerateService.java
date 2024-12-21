package com.yizlan.code.gen.service;

import com.yizlan.code.gen.dto.GeneratorParam;
import com.yizlan.code.gen.dto.JdbcParam;
import com.yizlan.code.gen.dto.ProjectSetting;
import com.yizlan.code.gen.dto.TableInfo;

import java.util.List;

/**
 * 生成代码 服务类
 *
 * @author Alias Zen
 * @version 1.0
 * @since 2022-11-24
 */
public interface GenerateService {

    ProjectSetting init();

    List<TableInfo> getTableList(JdbcParam jdbcParam);

    void generateCode(GeneratorParam generatorParam);
}
