<template>
  <div class="userIdInput"><el-input placeholder="请输入账号" v-model="LoginUser.userId"></el-input></div>
  <div class="userPasswordInput"><el-input placeholder="请输入密码" show-password v-model="LoginUser.userPassword"></el-input></div>
  <div><el-button @click="login">确认登录</el-button></div>
</template>

<script>
import axios from "axios";
export default {
  name: "Login",
  data() {
    return {
      LoginUser: {
        userId: '',
        userPassword: ''
      }
    }
  },
  methods: {
    login() {
      let formData = new FormData();
      formData.append('account', this.LoginUser.userId)
      formData.append('password',this.LoginUser.userPassword)
      axios.post("api/user/check", formData).then(res => {
        if (res.data === 1) {
          alert('成功')
        } else {
          alert('失败')
        }
      })
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
</style>