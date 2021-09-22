<template>
  <div class="horizontalBar">
    <span class="topText">欢迎来到商城</span>
  </div>

  <div class="ImgAndLoginBox">
    <div class="image">
      <img src="../assets/login/LoginImg1.jpg" alt="">
    </div>




    <div class="verticalBar"></div>
    <div class="login">
      <div class="choise">
        <el-button @click="gotoLogin" style="border: none">登录</el-button>
        <el-button @click="gotoRegister" style="border: none">注册</el-button>
      </div>
      <router-view></router-view>
    </div>
  </div>


  <div class="footer">
    <el-button type="primary" plain>团队</el-button>
  </div>
</template>

<script>
export default {
  name: "LoginAndRegister",
  methods: {
    gotoLogin: function(){
      this.$router.replace('/loginandregister/login')
    },
    gotoRegister: function(){
      this.$router.replace('/loginandregister/register')
    }
  }
}
</script>

<style scoped>
.ImgAndLoginBox{
  display: flex;
  position: relative;
  width: 980px;
  margin: 50px auto;
}
.image{
  width: 489px;
}
.login{
  padding-left: 45px;
  width: 490px;
  box-sizing: border-box;
}
.verticalBar {
  border-right: 1px solid RGBA(64,158,255,0.5);
  height: 300px;
  margin-top: 28px;
}
.horizontalBar{
  width: 980px;
  height: 28px;
  margin: 0 auto;
  margin-top: 100px;
  border-bottom: 1px solid RGBA(64,158,255,0.5);
  margin-bottom: 28px;
  text-align: center;
}
.topText{
  font-size: 38px;
  background: #fff;
  color: RGBA(64,158,255,0.7);
  margin: 0 auto;
  padding: 0 20px;
}
.choise{

  color: black;
  text-decoration: none;
}
.footer{
  height: 75px;
  padding: 25px 0;
  bottom: 0px;
  background-color: RGBA(64,158,255,0.05);
}
</style>