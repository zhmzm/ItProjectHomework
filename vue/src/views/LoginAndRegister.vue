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

  <el-dialog
      title="提示"
      v-model="logInDialogVisible"
      :visible.sync="logInDialogVisible"
      width="30%">
    <div style="margin-bottom: 30px">您已登录成功，无需再次登录！</div>
    <span slot="footer" class="dialog-footer">
            <el-button type="primary" @click="gotoHome">确 定</el-button>
            <el-button @click="gotoHome">取 消</el-button>
            </span>
  </el-dialog>

</template>

<script>
export default {
  name: "LoginAndRegister",
  data(){
    return{
      logInDialogVisible: false,
    }
  },
  methods: {
    gotoLogin: function(){
      this.$router.replace('/loginandregister/login')
    },
    gotoRegister: function(){
      this.$router.replace('/loginandregister/register')
    },
    gotoHome(){
      this.logInDialogVisible = false;
      this.$router.replace('/');
    },
  },
  created() {
     console.log(this.$store.state.login)
    if(this.$store.state.login === 1){
      this.logInDialogVisible = true;
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
  height: 380px;
  margin-top: 28px;
}
.horizontalBar{
  width: 980px;
  height: 28px;
  margin: 0 auto;
  margin-top: 50px;
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
</style>