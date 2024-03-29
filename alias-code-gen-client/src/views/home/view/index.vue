<template>
  <div id="components-layout-demo-basic">
    <a-layout>
      <a-layout-header>
        <a-icon type="code" /> <a-icon type="double-right" /> Alias Zen
      </a-layout-header>
      <a-layout-content>
        <div style="padding-top: 16px">
          <a-steps class="steps-title" :current="current">
            <a-step v-for="item in steps" :key="item.title" :title="item.title"/>
          </a-steps>
          <div class="steps-content">
              <code-form v-show="this.current === 0" :cfg="projects" :formRules="projects.rules" ref="projectsRef"/>
              <code-table ref="tablesRef" v-show="this.current === 1"/>
              <a-tabs v-show="this.current === 2">
                <a-tab-pane key="1" tab="数据表">
                  <code-form :cfg="tableNames" ref="tableNamesRef"/>
                </a-tab-pane>
                <a-tab-pane key="2" tab="包名">
                  <code-form :cfg="packages" ref="packagesRef"/>
                </a-tab-pane>
                <a-tab-pane key="3" tab="文件名">
                  <code-form :cfg="fileNames" ref="fileNamesRef"/>
                </a-tab-pane>
                <a-tab-pane key="4" tab="父类">
                  <code-form :cfg="superClasses" ref="superClassesRef"/>
                </a-tab-pane>
              </a-tabs>
              <a-collapse v-model="activeKey" v-show="this.current === 3">
                <a-collapse-panel key="1" header="全局策略" :showArrow="false" disabled>
                  <code-form :cfg="globalStrategy" ref="globalStrategyRef"/>
                </a-collapse-panel>
                <a-collapse-panel key="2" header="Entity策略" :showArrow="false" disabled>
                  <code-form :cfg="entityStrategy" ref="entityStrategyRef"/>
                </a-collapse-panel>
                <a-collapse-panel key="3" header="Controller策略" :showArrow="false" disabled>
                  <code-form :cfg="ctrlStrategy" ref="ctrlStrategyRef"/>
                </a-collapse-panel>
                <a-collapse-panel key="4" header="Mapper策略" :showArrow="false" disabled>
                  <code-form :cfg="mapperStrategy" ref="mapperStrategyRef"/>
                </a-collapse-panel>
              </a-collapse>
              <div v-show="this.current === 4">
                <code-description ref="confirmDescriptionRef"/>
                <code-simple-table ref="confirmInfoRef"/>
              </div>
          </div>
          <div class="steps-action">
            <a-button v-if="current < steps.length - 1" type="primary" @click="next">
              下一步
            </a-button>
            <a-button v-if="current == steps.length - 1" type="danger" @click="generate()">
              生成代码
            </a-button>
            <a-button v-if="current > 0" style="margin-left: 8px" @click="prev">
              上一步
            </a-button>
          </div>
        </div>
      </a-layout-content>
    </a-layout>
  </div>
</template>

<script>
import CodeForm from '@/components/code-form/index.vue'
import CodeTable from '@/components/code-table/index.vue'
import CodeDescription from '@/components/code-description/index.vue'
import CodeSimpleTable from '@/components/code-simple-table/index.vue'

import { initApi, getTablesApi, generateCodeApi } from '../api/index'
import { formatListToOptions, formatListToArrays } from '@/utils/format'

const projectRules = {
  projectLocation: [{ required: true, message: "请输入项目路径", trigger: "blur" }],
  developer: [{ required: true, message: "请输入开发人员", trigger: "blur" }],
  packageName: [{ required: true, message: "请输入包名", trigger: "blur" }],
  dbType: [{ required: true, message: "请选择数据库", trigger: "blur" }],
  host: [{ required: true, message: "请输入数据库地址", trigger: "blur" }],
  dbName: [{ required: true, message: "请输入数据库名称", trigger: "blur" }],
  userName: [{ required: true, message: "请输入用户名", trigger: "blur" }],
  password: [{ required: true, message: "请输入密码", trigger: "blur" }],
  xmlTargetDir: [{ required: true, message: "请选择xml生成目录", trigger: "blur" }],
};

const formItemLayout = {
  layout: "horizontal",
  labelCol: { span: 8 },
  wrapperCol: { span: 8 },
};

const switchLayout = {
  layout: "horizontal",
  labelCol: { span: 12 },
  wrapperCol: { span: 6 },
};

export default {
  components: {
    CodeForm,
    CodeTable,
    CodeSimpleTable,
    CodeDescription,
  },
  data() {
    return {
      current: 0,
      steps: [{title: "项目配置"}, {title: "选择数据表"}, {title: "个性化配置"}, {title: "策略配置"}, {title: "生成代码"}],
      activeKey: ["1", "2", "3", "4"],
      initList: {},
      projects: {
        layout: formItemLayout,
        itemList: [],
        rules: projectRules,
        span: 24,
      },
      tableNames: {
        layout: formItemLayout,
        itemList: [],
        span: 24,
      },
      packages: {
        layout: formItemLayout,
        itemList: [],
        span: 24,
      },
      fileNames: {
        layout: formItemLayout,
        itemList: [],
        span: 24,
      },
      superClasses: {
        layout: formItemLayout,
        itemList: [],
        span: 24,
      },
      globalStrategy: {
        layout: switchLayout,
        itemList: [],
      },
      entityStrategy: {
        layout: switchLayout,
        itemList: [],
      },
      ctrlStrategy: {
        layout: switchLayout,
        itemList: [],
      },
      mapperStrategy: {
        layout: switchLayout,
        itemList: [],
      },
      formModel: {},
    };
  },
  created() {
    this.init()
  },
  methods: {
    async init() {
      this.projects.itemList = [
        { type: "input", label: "项目路径", prop: "projectLocation", help: "生成代码的项目路径，配置到项目根目录即可", },
        { type: "input", label: "开发者", prop: "developer", help: "开发人员名称", },
        { type: "input", label: "包名", prop: "packageName",  help: "业务模块包路径，例如：com.aliaszen.**.**.base", },
        { type: "select", label: "数据库类型", prop: "dbType", },
        { type: "input", label: "地址", prop: "host", help: "数据库地址格式：ip:port", },
        { type: "input", label: "schema", prop: "schema", help: "数据库schema, 部分数据库适用", },
        { type: "input", label: "数据库", prop: "dbName", help: "数据库的名称", },
        { type: "input", label: "用户名", prop: "userName", help: "数据库的用户名", },
        { type: "input", label: "密码", prop: "password", help: "数据库的密码", },
        { type: "select", label: "Xml", prop: "xmlTargetDir", help: "生成XML的目录",
        },
      ]

      this.tableNames.itemList = [
        { type: "input", label: "数据表前缀", prop: "tablePrefix", help: "忽略的表前缀，生成后的实体类名会忽略前缀", },
        { type: "input", label: "数据表后缀", prop: "tableSuffix", help: "忽略的表后缀，生成后的实体类名会忽略后缀", },
        { type: "input", label: "表字段前缀", prop: "tableFieldPrefix", help: "忽略的表字段前缀，生成后的实体类字段名会忽略前缀", },
        { type: "input", label: "表字段后缀", prop: "tableFieldSuffix", help: "忽略的表字段后缀，生成后的实体类字段名会忽略后缀", },
      ]

      this.packages.itemList = [
        { type: "input", label: "实体类", prop: "packageEntity", help: "默认: entity" },
        { type: "input", label: "Controller", prop: "packageCtrl", help: "默认: controller" },
        { type: "input", label: "Service", prop: "packageService", help: "默认: service" },
        { type: "input", label: "ServiceImpl", prop: "packageServiceImpl", help: "默认: service.impl" },
        { type: "input", label: "Mapper ", prop: "packageMapper", help: "默认: mapper" },
        { type: "input", label: "Xml", prop: "packageMapperXml", help: "默认: mapper.xml" },
      ]

      this.fileNames.itemList = [
        { type: "input", label: "实体类", prop: "fileNameEntity", help: "默认: %s" },
        { type: "input", label: "Controller", prop: "fileNameCtrl", help: "默认: %sController" },
        { type: "input", label: "Service", prop: "fileNameService", help: "默认: I%sService" },
        { type: "input", label: "ServiceImpl", prop: "fileNameServiceImpl", help: "默认: %sServiceImpl" },
        { type: "input", label: "Mapper", prop: "fileNameMapper", help: "默认: %sMapper" },
        { type: "input", label: "Xml", prop: "fileNameMapperXml", help: "默认: %sMapper" },
      ]

      this.superClasses.itemList = [
        { type: "input", label: "实体类", prop: "superClassEntity", help: "example: com.*...*.BaseEntity" },
        { type: "input", label: "Controller", prop: "superClassCtrl", help: "example: com.*...*.BaseController" },
        { type: "input", label: "Service", prop: "superClassService", help: "example: com.*...*.BaseService" },
        { type: "input", label: "ServiceImpl", prop: "superClassServiceImpl", help: "example: com.*...*.BaseServiceImpl" },
        { type: "input", label: "Mapper", prop: "superClassMapper", help: "example: com.*...*.BaseMapper" },
      ];

      this.globalStrategy.itemList = [
        { type: "switch", label: "Kotlin项目", prop: "kotlinProject" },
        { type: "switch", label: "Swagger文档", prop: "useSwagger" },
      ]

      this.entityStrategy.itemList = [
        { type: "switch", label: "表注解", prop: "useTableAnnotation" },
        { type: "switch", label: "字段注解", prop: "useTableFieldAnnotation", },
        { type: "switch", label: "禁用序列化", prop: "disableSerialization" },
        { type: "switch", label: "lombok注解", prop: "useLombok" },
      ]

      this.ctrlStrategy.itemList = [
        { type: "switch", label: "URL使用驼峰转连字符", prop: "useHyphen" },
        { type: "switch", label: "Rest风格", prop: "useRestStyle" },
      ]

      this.mapperStrategy.itemList = [
        { type: "switch", label: "BaseResultMap", prop: "generateBaseResultMap", },
        { type: "switch", label: "BaseColumnList", prop: "generateBaseColumnList", },
        { type: "switch", label: "Mapper注解", prop: "useMapperAnnotation", },
      ]

      const data = await initApi()
      if (data === false) return
      this.$refs.projectsRef.setOptions('dbType', formatListToOptions(data.dbTypeList, 'itemText', 'itemValue'))
      this.$refs.projectsRef.setOptions('xmlTargetDir', formatListToOptions(data.xmlDirList, 'itemText', 'itemValue'))
    },
    async next() {
      if (this.current === 0) {
        const valid = await this.$refs.projectsRef.validateForm();
        if (!valid) {
          return
        }
      }
      this.current++
      if (this.current === 1) {
        const param = await this.$refs.projectsRef.getFormModel();
        const tables = await getTablesApi(param)
        this.$refs.tablesRef.setDataSource(tables);
        Object.assign(this.formModel, param);
      }
      if (this.current === 2) {
        const tables = {
            generateTableList: this.$refs.tablesRef.selectedRows
        }
        Object.assign(this.formModel, tables)
      }
      if (this.current === 3) {
        const tableNames = this.$refs.tableNamesRef.getFormModel();
        Object.assign(this.formModel, tableNames)

        const packagesRef = this.$refs.packagesRef
        if (packagesRef) {
          const packages = packagesRef.getFormModel();
          Object.assign(this.formModel, packages)
        }

        const fileNamesRef = this.$refs.fileNamesRef
        if (fileNamesRef) {
          const fileNames = fileNamesRef.getFormModel();
          Object.assign(this.formModel, fileNames)
        }

        const superClassesRef = this.$refs.superClassesRef
        if (superClassesRef) {
          const superClasses = superClassesRef.getFormModel();
          Object.assign(this.formModel, superClasses)
        }
      }
      if (this.current === 4) {
        const globalStrateg = this.$refs.globalStrategyRef.getFormModel();
        Object.assign(this.formModel, globalStrateg)
        
        const entityStrategy = this.$refs.entityStrategyRef.getFormModel();
        Object.assign(this.formModel, entityStrategy)
        
        const ctrlStrategy = this.$refs.ctrlStrategyRef.getFormModel();
        Object.assign(this.formModel, ctrlStrategy)
        
        const mapperStrategy = this.$refs.mapperStrategyRef.getFormModel();
        Object.assign(this.formModel, mapperStrategy)

        const confirmDescription = {
          bordered: true,
          layout: 'vertical',
          itemList: [{
              label: '项目路径',
              value:  this.formModel.projectLocation
          },{
              label: '代码包路径',
              value: this.formModel.packageName
          }],
        }
        this.$refs.confirmDescriptionRef.setItem(confirmDescription)

        let selectedTableObjList= {... this.formModel.generateTableList}
        const selectedTables = formatListToArrays(selectedTableObjList)
        this.$refs.confirmInfoRef.setTables(selectedTables)
      }
    },
    prev() {
      this.current--
    },
    generate() {
      generateCodeApi(this.formModel)
    },
  },
};
</script>

<style>
#components-layout-demo-basic {
  /* text-align: center; */
  height: 100vh;
  overflow: scroll;
}
#components-layout-demo-basic .ant-layout-header {
  background: #0367b9;
  color: #fff;
}
#components-layout-demo-basic .ant-layout-content {
  /* background: rgba(16, 142, 233, 1); */
  background-color: transparent;
  color: #fff;
  /* min-height: 120px;
  line-height: 120px; */
  height: 100%;
}

.steps-content {
  margin-top: 16px;
  border: 1px dashed #e9e9e9;
  border-radius: 6px;
  background-color: #fff;
  min-height: 200px;
  /* text-align: center; */
}

.steps-action {
  margin-top: 24px;
  margin-bottom: 24px;
  text-align: center;
}

.ant-advanced-search-form .ant-form-item {
  display: flex;
}
</style>
