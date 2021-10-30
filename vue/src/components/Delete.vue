<template>
  <div style="margin-top: 50px; margin-left: 150px">
    <el-button class="eachButton" type="primary" plain v-for="item in allItem" :key="item.id" @click="deleteDialog(item.id)">
      商品名：{{item.name}} , 商品id：{{item.id}}
    </el-button>
    <el-dialog
        title="提示"
        v-model="dialogVisible"
        :visible.sync="dialogVisible"
        width="30%">
      <div style="margin-bottom: 30px">您确定要删除商品{{nowProduct}}吗？</div>
      <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="deleteProduct">确 定</el-button>
        <el-button @click="dialogVisible = false">取 消</el-button>
      </span>
    </el-dialog>

  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "Delete",

  data() {
    return {
      dialogVisible: false,
      nowProduct: '',
      allID: [],
      allItem: [],  //所有商品的数据
      tempObj: ""   ,//用来存放取出的一个属性

    }
  },

  methods: {
    deleteDialog(npID){
      this.dialogVisible = true;
      this.nowProduct = npID;
    },
    deleteProduct(){
      this.dialogVisible = false;
      let formData = new FormData();
      formData.append('id', this.nowProduct);
      axios.post("http://localhost:8080/api/commodity/del", formData).then(res => {
        location.reload();
      })
    }
  },

  created () {
    if(this.$store.state.login === 0){
      alert('请先登录！');
      this.$router.replace('/administrator');
    }
    else{
      let formData1 = new FormData();
      formData1.append('userId', this.$store.state.user.id.toString())
      axios.post("http://localhost:8080/api/jurisdiction/check", formData1).then(res => {
        if(res.data.sellerPower !== 1 && res.data.administratorPower !== 1){
          alert('您没有权限进入此界面。');
          this.$router.replace('/administrator');
        }
      })
    }

    axios.post("http://localhost:8080/api/commodity/shoplist").then(async res =>{
      this.allID = res.data;
      for(let i = 0; i < this.allID.length; i++){

        //请求商品信息数据
        let formDataDetail = new FormData();
        formDataDetail.append('id', this.allID[i]);
        await axios.post("http://localhost:8080/api/commodity/check", formDataDetail).then(res =>{
          this.tempObj = res.data;
          this.allItem.push(this.tempObj);
        });
        formDataDetail.delete('id');
      }
      console.log(this.allItem);
    });
  },
}


</script>

<style scoped>
.eachButton{
  display: block;
  text-align: left;
  width: 500px;
  margin: 20px 50px 20px 150px;
}
</style>


