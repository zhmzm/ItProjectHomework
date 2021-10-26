<template>
  <el-menu
      :default-active="activeIndex"
      class="el-menu-demo"
      mode="horizontal"
      @select="handleSelect"
      id="header"
      style="z-index: 999; background-color: RGBA(64,158,255,0.05);"
  >
    <el-menu-item index="1" @click="gotoHome" >主页</el-menu-item>
    <el-sub-menu index="2">
      <template #title>商城</template>
      <el-menu-item index="2-1">选项1</el-menu-item>
      <el-menu-item index="2-2">选项2</el-menu-item>
      <el-menu-item index="2-3">选项3</el-menu-item>
      <el-sub-menu index="2-4">
        <template #title>选项4</template>
        <el-menu-item index="2-4-1">选项1</el-menu-item>
        <el-menu-item index="2-4-2">选项2</el-menu-item>
        <el-menu-item index="2-4-3">选项3</el-menu-item>
      </el-sub-menu>
    </el-sub-menu>
    <el-menu-item index="3">个人中心</el-menu-item>
    <el-menu-item index="4" @click="gotoLoginAndRegister">注册登录</el-menu-item>
  </el-menu>
  <div class="line"></div>




  <router-view/>
</template>

<script>
export default {
  methods: {
    gotoLoginAndRegister: function(){
      this.$router.replace('/loginandregister')
    },
    gotoHome(){
      this.$router.replace('/Shop')
    }
  },
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}


</style>
