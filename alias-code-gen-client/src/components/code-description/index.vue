<template>
  <a-descriptions
    :layout="cfg.layout"
    :bordered="cfg.bordered"
    style="word-break: break-all; word-wrap: break-word"
  >
    <a-descriptions-item v-for="(item, index) in cfg.itemList" :key="index" :label="item.label" :span="span">
      {{ item.value }}
    </a-descriptions-item>
  </a-descriptions>
</template>

<script>
export default {
  name: "CodeDescription",
  data() {
    return {
      cfg: {
        bordered: false,
        layout: "horizontal",
        itemList: [],
      }
    };
  },
  computed: {
    span() {
      const screenWidth = document.body.clientWidth;
      if (screenWidth < 1080) {
        return 1;
      }
      return 4;
    },
  },
  methods: {
    setItem(cfg) {
      this.cfg = cfg
    }
  }
};
</script>
