<template>
  <div class="form-item">
    <a-input
      v-if="itemCfg.type === 'input'"
      allowClear
      v-model="currentVal"
      v-bind="bindProps"
      v-on="bindEvents"
    />

    <code-select
      v-if="itemCfg.type === 'select'" 
      v-model="currentVal" 
      :cfg="itemCfg" 
      :new-options="newOptions"
      />

    <a-switch       
      v-if="itemCfg.type === 'switch'"
      allowClear
      v-model="currentVal"
      v-bind="bindProps"
      v-on="bindEvents"
      />

    <code-simple-table 
      v-if="itemCfg.type === 'simple-table'" 
      :cfg="itemCfg"
      />
  </div>
</template>

<script>
import CodeSelect from '../code-select/index.vue'
import CodeSimpleTable from '../code-simple-table/index.vue'

export default {
  components: {
    CodeSelect,
    CodeSimpleTable,
  },
  name: "CodeFormItem",
  inheritAttrs: false,
  props: {
    value: {},
    itemCfg: {
      type: Object,
      default() {
        return {};
      },
    },
  },
  data() {
    return {
      newOptions: [],
    };
  },
  computed: {
    // 双向绑定数据值
    currentVal: {
      get() {
        return this.value;
      },
      set(val) {
        this.$emit("input", val);
      },
    },
    // 绑定属性
    bindProps() {
      const obj = { ...this.itemCfg };
      // 移除冗余属性
      delete obj.label;
      delete obj.prop;
      delete obj.type;
      delete obj.initValue;
      delete obj.rules;
      delete obj.events;
      delete obj.type;
      return obj;
    },
    // 绑定方法
    bindEvents() {
      return this.itemCfg.events || {};
    },
  },
  methods: {
  },
};
</script>
