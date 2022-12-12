<template>
  <a-config-provider :locale="locale">
    <div id="app">
      <router-view/>
    </div>
  </a-config-provider>
</template>

<script>
import zhCN from 'ant-design-vue/es/locale/zh_CN'

export default {
  data() {
    return {
      locale: zhCN
    }
  }
}
</script>

<style lang="less">
#app {
  width: 100%;
  height: 100%;
  overflow: scroll;
}
input {
  background-color: rgba(0, 0, 0, 0);
}
button {
  position: relative;
}
button::before {
  position: absolute;
  top: 50%;
  left: 50%;
  width: 100%;
  height: 100%;
  background-color: #000;
  border: inherit;
  border-color: #000;
  border-radius: inherit;
  transform: translate(-50%, -50%);
  opacity: 0;
  content: '';
}
button:active::before {
  opacity: 0.1;
}
body,
input,
button {
  margin: 0;
  padding: 0;
  border: 0;
}
</style>
