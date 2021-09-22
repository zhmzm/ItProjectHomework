<template>
  <div class="userIdInput"><el-input placeholder="请输入新账号" v-model="RegisterUser.userId"></el-input></div>
  <div class="userPasswordInput"><el-input placeholder="请输入您的密码" show-password v-model="RegisterUser.userPassword"></el-input></div>
  <div class="userRepeatInput"><el-input placeholder="请再次输入密码" show-password v-model="RegisterUser.userRepeat"></el-input></div>
  <div class="userIdInput"><el-input placeholder="请输入名称" v-model="RegisterUser.userName"></el-input></div>
  <div class="userIdInput"><el-input placeholder="请输入电话" v-model="RegisterUser.userPhone"></el-input></div>
  <div><el-button @click="register">确认注册</el-button></div>
</template>

<script>
import axios from "axios";
export default {
  name: "Register",
  data() {
    return {
      RegisterUser: {
        userName: '',
        userId: '',
        userPassword: '',
        userRepeat: '',
        userPhone: ''
      }
    }
  },
  methods: {
    register(){
      if(this.RegisterUser.userPassword === this.RegisterUser.userRepeat){
        let formData = new FormData();
        formData.append('account',this.RegisterUser.userId)
        formData.append('password','1')
        axios.post("api/user/add", formData).then(res => {
          alert('成功注册')
        })
      }else{
        alert('密码与重复输入的密码不一致')
      }
    }
  }
}
</script>

<style scoped>
.userIdInput{
  margin: 20px 20px 10px 20px
}
.userPasswordInput{
  margin: 20px 20px 10px 20px
}
.userRepeatInput{
  margin: 20px 20px 20px 20px
}
</style>