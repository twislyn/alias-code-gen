<template>
  <a-table
    :columns="columns"
    :data-source="data"
    :pagination="false"
    bordered
    size="middle"
  />
</template>

<script>
const columns = [
  {
    title: "选中的数据表",
    dataIndex: "tableName",
    key: "tableName",
    customHeaderCell: () => ({
      style: {
        textAlign: "center",
      },
    }),
  },
  {
    title: "实体描述",
    dataIndex: "tableComment",
    key: "tableComment",
    customHeaderCell: () => ({
      style: {
        textAlign: "center",
      },
    }),
  },
];

export default {
  name: "CodeSimpleTable",
  data() {
    return {
      data: [],
      columns: columns,
    };
  },
  methods: {
    setTables(data) {
      this.data = data;
    },
  },
};
</script>
