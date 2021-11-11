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
    <el-menu-item index="5" @click="logOutDialog">退出登录</el-menu-item>
    <el-menu-item index="6" @click="gotoAdministrator" style="margin-right: 10px; margin-left: auto">后台管理</el-menu-item>
    <el-sub-menu index="7">
      <template #title>卖家中心</template>
      <el-menu-item index="7-1" @click="gttoBusinessMessage">商家信息</el-menu-item>
    </el-sub-menu>
    <el-menu-item index="8" @click="gotoComments">评价</el-menu-item>
  </el-menu>
  <div class="line"></div>
  <el-dialog
      title="提示"
      v-model="logOutDialogVisible"
      :visible.sync="logOutDialogVisible"
      width="30%">
    <div style="margin-bottom: 30px">确认退出账号</div>
    <span slot="footer" class="dialog-footer">
            <el-button type="primary" @click="logOut">确 定</el-button>
            <el-button @click="logOutDialogVisible = false">取 消</el-button>
            </span>
  </el-dialog>



  <router-view/>
</template>

<script>
export default {
  data (){
    return{
      logOutDialogVisible: false
    }
  },
  methods: {
    gotoLoginAndRegister: function(){
      this.$router.replace('/loginandregister')
    },
    gotoComments:function (){
      this.$router.replace('/comment')
    },
    gotoHome(){
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
    },
    logOutDialog(){
      this.logOutDialogVisible = true
    },
    gotoBusiness:function ()
    {
      this.$router.replace('/business')
    },
    gttoBusinessMessage:function ()
    {
      this.$router.replace('/businessmessage')
    },
    logOut(){
      this.logOutDialogVisible = false
      this.$store.commit('setUser', '');
      this.$store.commit('setLogin', 0);
    }
  },
  created () {
    //在页面加载时读取sessionStorage里的状态信息
    if (sessionStorage.getItem("store") ) {
      this.$store.replaceState(Object.assign({}, this.$store.state,JSON.parse(sessionStorage.getItem("store"))))
    }

    //在页面刷新时将vuex里的信息保存到sessionStorage里
    window.addEventListener("beforeunload",()=>{
      sessionStorage.setItem("store",JSON.stringify(this.$store.state))
    })
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
