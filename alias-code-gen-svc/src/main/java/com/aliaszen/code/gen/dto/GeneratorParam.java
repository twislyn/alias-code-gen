package com.aliaszen.code.gen.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 生成参数
 *
 * @author Alias Zen
 * @version 1.0
 * @since 2022-12-05
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class GeneratorParam {
    /**
     * 项目生成位置
     */
    private String projectLocation;
    /**
     * 开发者
     */
    private String developer;
    /**
     * 包名
     */
    private String packageName;
    /**
     * 数据库类型
     */
    private String dbType;
    /**
     * ip:port
     */
    private String host;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 数据库名
     */
    private String dbName;
    /**
     * xml源码目录
     */
    private String xmlTargetDir;
    /**
     * 数据表信息
     */
    private List<TableInfo> generateTableList;

    /*
     * 数据表
     */
    private String tablePrefix;
    private String tableSuffix;
    private String tableFieldPrefix;
    private String tableFieldSuffix;

    /*
     * 包名
     */
    private String packageEntity;
    private String packageCtrl;
    private String packageService;
    private String packageServiceImpl;
    private String packageMapper;
    private String packageMapperXml;

    /*
     * 文件名
     */
    private String fileNameEntity;
    private String fileNameCtrl;
    private String fileNameService;
    private String fileNameServiceImpl;
    private String fileNameMapper;
    private String fileNameMapperXml;

    /*
     * 父类
     */
    private String superClassEntity;
    private String superClassCtrl;
    private String superClassService;
    private String superClassServiceImpl;
    private String superClassMapper;

    /**
     * kotlin项目
     */
    private Boolean kotlinProject;
    /**
     * 使用Swagger
     */
    private Boolean useSwagger;
    /**
     * 使用表注解
     */
    private Boolean useTableAnnotation;
    /**
     * 使用字段注解
     */
    private Boolean useTableFieldAnnotation;
    /**
     * 禁用序列化
     */
    private Boolean disableSerialization;
    /**
     * 使用Lombok
     */
    private Boolean useLombok;
    /**
     * 开启RestApi
     */
    private Boolean useRestStyle;
    /**
     * URL使用驼峰转连字符
     */
    private Boolean useHyphen;
    /**
     * 使用 @Mapper 注解
     */
    private Boolean useMapperAnnotation;
    /**
     * 生成BaseResultMap
     */
    private Boolean generateBaseResultMap;
    /**
     * 生成BaseColumnList
     */
    private Boolean generateBaseColumnList;
}
