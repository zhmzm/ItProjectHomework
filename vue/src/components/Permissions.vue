<template>
  <div style="margin-top: 50px; margin-left: 150px">
    <el-button class="eachButton" type="primary" plain v-for="(item, index) in allPermissions"
               :key="item.id" @click="permissionsDialog(allUser[index].id, item.administratorPower, item.sellerPower)">
      用户ID：{{allUser[index].id}}
      <span v-if="item.administratorPower === 1"> ，拥有权限：管理员 </span>
      <span v-if="item.sellerPower === 1"> ，拥有权限：商家 </span>
    </el-button>
    <el-dialog
        title="提示"
        v-model="dialogVisible"
        :visible.sync="dialogVisible"
        width="60%">
      <div style="margin-bottom: 30px">请管理用户{{nowUser}}的权限</div>
      <span slot="footer" class="dialog-footer">
        <el-button class="dialogButton" type="primary" @click="postPermissions(1)">普通用户</el-button>
        <el-button class="dialogButton" type="primary" @click="postPermissions(2)">商 家</el-button>
        <el-button class="dialogButton" type="primary" @click="postPermissions(3)">管 理 员</el-button>
        <el-button class="dialogButton" type="primary" @click="postPermissions(4)">管理员和商家</el-button>
        <el-button @click="dialogVisible = false">取 消</el-button>
      </span>
    </el-dialog>
  </div>

</template>

<script>
import axios from "../axios/axios";

export default {
  name: "Permissions",
  data(){
    return{
      allUser: '',
      allPermissions: [],
      dialogVisible: false,
      nowUser: '',
      nowUserSellerPermissions: '',
      nowUserAdministratorPermissions: '',
    }
  },
  methods: {
    permissionsDialog(nuID, nuSeller, nuAd) {
      this.dialogVisible = true;
      this.nowUser = nuID.toString();
      if(nuSeller === 1){
        this.nowUserSellerPermissions = '1';
      }else{
        this.nowUserSellerPermissions = '0';
      }
      if(nuAd === 1){
        this.nowUserAdministratorPermissions = '1';
      }else{
        this.nowUserAdministratorPermissions = '0';
      }

    },
    postPermissions(choise) {
      //有权限的话 先删后增
      if(this.nowUserSellerPermissions !== '0' || this.nowUserAdministratorPermissions !== '0'){
        let delFormData = new FormData();
        delFormData.append('userId', this.nowUser);
        axios.post("/jurisdiction/del", delFormData).then(async res => {
          let formData1 = new FormData();
          if(choise === 1){
            await location.reload();
          }
          else if(choise === 2){
            formData1.append('administratorPower', '0')
            formData1.append('sellerPower', '1')
            formData1.append('userId', this.nowUser);
            await axios.post("/jurisdiction/add", formData1).then(async res => {
              await location.reload();
            })
          }
          else if(choise === 3){
            formData1.append('administratorPower', '1')
            formData1.append('sellerPower', '0')
            formData1.append('userId', this.nowUser);
            await axios.post("/jurisdiction/add", formData1).then(async res => {
              await location.reload();
            })
          }
          else if(choise === 4){
            formData1.append('administratorPower', '1')
            formData1.append('sellerPower', '1')
            formData1.append('userId', this.nowUser);
            await axios.post("/jurisdiction/add", formData1).then(async res => {
              await location.reload();
            })
          }

        })
      }
      //无权限 直接添加
      else{
        let formData2 = new FormData();
        if(choise === 2){
          formData2.append('administratorPower', '0')
          formData2.append('sellerPower', '1')
          formData2.append('userId', this.nowUser);
          axios.post("/jurisdiction/add", formData2).then(async res => {
            await location.reload();
          })
        }else if(choise === 3){
          formData2.append('administratorPower', '1')
          formData2.append('sellerPower', '0')
          formData2.append('userId', this.nowUser);
          axios.post("/jurisdiction/add", formData2).then(async res => {
            await location.reload();
          })
        }
        else if(choise === 4){
          formData2.append('administratorPower', '1')
          formData2.append('sellerPower', '1')
          formData2.append('userId', this.nowUser);
          axios.post("/jurisdiction/add", formData2).then(async res => {
            await location.reload();
          })
        }
      }

    },
  },

  created () {
    if(this.$store.state.login === 0){
      alert('请先登录！');
      this.$router.replace('/administrator');
    }
    else{
      let formData1 = new FormData();
      formData1.append('userId', this.$store.state.user.id.toString())
      axios.post("/jurisdiction/check", formData1).then(res => {
        if(res.data.administratorPower !== 1){
          alert('您没有权限进入此界面。');
          this.$router.replace('/administrator');
        }
      })
    }

    axios.post("/userInfo/checkAll").then(async res =>{
      this.allUser = res.data;
      for(let i = 0; i < this.allUser.length; i++){
        //请求用户权限数据
        let formDataPermissions = new FormData();
        formDataPermissions.append('userId ', this.allUser[i].id.toString());
        await axios.post("/jurisdiction/check", formDataPermissions).then(res =>{
          this.allPermissions.push(res.data);
        });
        formDataPermissions.delete('userId');
      }
    });
  },
}
</script>

<style scoped>
.eachButton{
  display: block;
  text-align: left;
  width: 500px;
  margin: 20px 50px 20px 120px;
}
.dialogButton{
  width: 150px;
  margin: 20px 20px 20px 20px;
}
</style>