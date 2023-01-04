<template>
  <a-form-model
    :model="formModel"
    ref="formRef"
    :rules="rules"
    :layout="formItemLayout.layout"
    :label-col="formItemLayout.labelCol"
    :wrapper-col="formItemLayout.wrapperCol"
  >
    <a-row align="middle" :gutter="{ sm: 8, md: 12, xl: 20 }">
      <a-col v-for="(item, index) in itemList" :key="index" :span="span">
        <a-form-model-item
          :label="item.label ? item.label : ''"
          :prop="item.prop"
          :help="item.help"
        >
          <code-form-item
            :ref="item.prop + 'Ref'"
            v-model.trim="formModel[item.prop]"
            :item-cfg="item"
          />
        </a-form-model-item>
      </a-col>
    </a-row>
  </a-form-model>
</template>

<script>
import CodeFormItem from "../code-form-item/index.vue"
import ComponentBus from "../component-bus"

export default {
  name: "CodeForm",
  components: { CodeFormItem },
  props: {
    cfg: {
      type: Object,
      required: true,
      default() {
        return {};
      },
    },
    formRules: {
      type: Object,
      default() {
        return {};
      },
    },
  },
  data() {
    return {
      formModel: {},
      formItemLayout: this.cfg.layout,
      itemList: this.cfg.itemList,
      rules: this.formRules,
    };
  },
  computed: {
    span() {
      if(this.cfg.span){
        return this.cfg.span
      }
      const screenWidth = document.body.clientWidth;
      if (screenWidth < 1080) {
        return 12;
      } else if (screenWidth < 1200) {
        return 8;
      }
      return 6;
    },
  },
  mounted() {
    ComponentBus.$on("sfCodeNameInput", (prop, value) => {
      if (prop) {
        const ref = this.$refs[prop + "Ref"];
        if (ref) {
          this.formModel[prop] = value;
        }
      }
    });
  },
  methods: {
    filterFormModel() {
      const formEntity = {};
      const arr = Object.keys(this.formModel);
      for (const element of arr) {
        const key = element;
        if (this.formModel[key]) {
          formEntity[key] = this.formModel[key];
        }
      }
      return formEntity;
    },

    setOptions(itemProp, options) {
      ComponentBus.$emit("sfSelectOptionsChange", itemProp, options);
    },
    getFormModel() {
      const formEntity = this.filterFormModel();
      return { ...formEntity };
    },
    async validateForm() {
      return await this.$refs.formRef.validate()
    },
  },
};
</script>
