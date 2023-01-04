<template>
  <a-select
    v-model="currentVal"
    allowClear
    :placeholder="cfg.placeholder ? cfg.placeholder : '请选择'"
    v-bind="bindProps"
    v-on="bindEvents"
    clearable
  >
    <a-select-option v-for="item in selectOptions" :key="item.value" :value="item.value">
      {{ item.label }}
    </a-select-option>
  </a-select>
</template>

<script>
import ComponentBus from "../component-bus"

export default {
  name: "CodeSelect",
  props: {
    value: {},
    cfg: {
      type: Object,
      default() {
        return {};
      },
    },
  },
  data() {
    return {
      selectOptions: this.cfg.options || [],
    };
  },
  watch: {
    cfg: {
      handler(value) {
        this.selectOptions = value.options || [];
        this.selectOptions = this.selectOptions.slice(0);
      },
      deep: true,
      immediate: true,
    },
  },
  created() {
    if (this.value) {
      this.currentVal = this.value;
    } else {
      this.currentVal = undefined;
    }
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
      const obj = { ...this.cfg };
      // 移除冗余属性
      delete obj.label;
      delete obj.prop;
      delete obj.type;
      delete obj.initValue;
      delete obj.rules;
      delete obj.events;
      delete obj.type;
      delete obj.options;
      // delete obj.placeholder
      return obj;
    },
    // 绑定方法
    bindEvents() {
      return this.cfg.events || {};
    },
  },
  mounted() {
    ComponentBus.$on("sfSelectOptionsChange", (itemProp, options) => {
      if (this.cfg.prop === itemProp) {
        this.currentVal = undefined;
        this.selectOptions = [...options];
      }
    });
  },
};
</script>
