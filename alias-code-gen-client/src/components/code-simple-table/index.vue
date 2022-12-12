<template>
  <a-table :columns="columns" :data-source="data" bordered>
    <template slot="title" >
        <!-- <code-form :cfg="tableNames"/> -->
        选中的数据表
    </template>
  </a-table>
</template>
<script>

const formItemLayout = {
  layout: "horizontal",
  labelCol: { span: 8 },
  wrapperCol: { span: 8 },
};

export default {
  name: "CodeSimpleTable",
  props:{
        cfg: {
      type: Object,
      default() {
        return {};
      },
    },
  },
  data() {
    return {
      data: this.cfg.data,
      columns: this.cfg.columns,
      tableNames: {
        layout: formItemLayout,
        itemList: [],
        span: 24,
      },
    };
  },
  created(){
    this.initialize();
  },
  methods: {
    initialize() {
        this.tableNames.itemList = [
        { type: "input", label: "代码包路径", prop: "tablePrefix", },
      ];
    },

    setTables(data){
        this.data=data
    }
  }
};
</script>
<style>
th.column-money,
td.column-money {
  text-align: right !important;
}
</style>
