package com.aliaszen.code.gen.controller;

import com.aliaszen.code.gen.dto.GeneratorParam;
import com.aliaszen.code.gen.dto.JdbcParam;
import com.aliaszen.code.gen.dto.DictKeyValue;
import com.aliaszen.code.gen.dto.TableInfo;
import com.aliaszen.code.gen.service.GenerateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 代码生成
 *
 * @author Alias Zen
 * @version 1.0
 * @since 2022-11-24
 */
@RestController
public class GeneratorController {

    @Resource
    private GenerateService generateService;

    /**
     * 获取数据库类型
     * @return 数据库类型
     */
    @GetMapping("/generator/dbTypes")
    public List<DictKeyValue> queryDbTypeList(){
        return generateService.getDbType();
    }

    /**
     * 获取数据表
     * @param jdbcParam 数据库参数
     * @return 数据表
     */
    @PostMapping("/generator/tables")
    public List<TableInfo> getTableList(@RequestBody JdbcParam jdbcParam){
        return generateService.getTableList(jdbcParam);
    }

    /**
     * 生成代码
     * @param generatorParam 生成参数
     */
    @PostMapping("/generator/generate")
    public void generateCode(@RequestBody GeneratorParam generatorParam){
        generateService.generateCode(generatorParam);
    }
}
