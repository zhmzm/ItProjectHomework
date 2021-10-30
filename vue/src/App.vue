<template>
  <el-menu
      class="el-menu-demo"
      mode="horizontal"
      id="header"
      style="z-index: 999; background-color: RGBA(64,158,255,0.05);"
  >
    <el-menu-item index="1" @click="gotoHome" >主页</el-menu-item>
    <el-sub-menu index="2">
      <template #title>个人中心</template>
      <el-menu-item index="2-1">个人信息</el-menu-item>
      <el-menu-item index="2-2" @click="gotoShoppingCart">购物车</el-menu-item>
    </el-sub-menu>
    <el-menu-item index="3" @click="gotoShop">商城</el-menu-item>
    <el-menu-item index="4" @click="gotoLoginAndRegister">注册登录</el-menu-item>
    <el-menu-item index="5" @click="gotoAdministrator" style="margin-right: 10px; margin-left: auto">后台管理</el-menu-item>
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
<<<<<<< HEAD
      this.$router.replace('/')
    },
    gotoShop(){
      this.$router.replace('/shop')
    },
    gotoAdministrator(){
      this.$router.replace('/administrator')
    },
    gotoShoppingCart(){
      this.$router.replace('/shoppingcart')
=======
      this.$router.replace('/Shop')
>>>>>>> 0c495a69441cacc5e84fb670dd3842baf03887a9
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
