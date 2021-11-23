<template>
  <div v-if="isBusiness">
    <el-descriptions title="我的信息" direction="vertical" :column="4" border>
    <el-descriptions-item label="用户名">
      <el-input v-model="this.message.name"></el-input>
    </el-descriptions-item>
    <el-descriptions-item label="手机号">
      <el-input
          type="text"
          placeholder="请输入内容"
          v-model="this.message.phoneNumber"
          maxlength="11"
          show-word-limit
      >
      </el-input>
    </el-descriptions-item>
    <el-descriptions-item label="注册时间" :span="2">{{this.message.registerTime}}</el-descriptions-item>
    <el-descriptions-item label="eMail">
      <el-input v-model="this.message.eMail"></el-input>
    </el-descriptions-item>
    <el-descriptions-item label="店铺星级">评分
      <el-rate
        v-model="this.a"
        disabled
        show-score
        text-color="#ff9900"
        score-template="{value}">
    </el-rate>
    </el-descriptions-item>
    <el-descriptions-item>
      <el-button type="success" @click="updateMessage()">确定修改信息</el-button>
    </el-descriptions-item>
  </el-descriptions>
    <div class="business">

      <!--  头部-->
      <div class="header">
        <div class="content">
          <p align="left">{{this.message.name}}的商品列表</p>
        </div>
      </div>
      <!--  头部-->
      <div class="list" v-if="commodityList.length>0">
        <ul>
          <li class="list-header">
            <p> </p>
            <div class="bus-name">商品名称</div>
            <div class="bus-inventory">库存</div>
            <div class="bus-price">价格</div>
            <div class="bus-discount">折扣</div>
          </li>
          <li class="Commodities-list" v-for="item in commodityList">
            <div class="bus-img">
              <img :src="'https://xuenihongzhao.info/'+item.adress"/>
            </div>
            <div class="bus-name">
              <router-link :to="{ path: '/shop/detail', query: {id:item.id} }">{{item.name}}</router-link>
            </div>
            <div class="bus-inventory">{{item.inventory}}</div>
            <div class="bus-price">{{item.prise}}</div>
            <div class="bus-discount">{{item.discount}}</div>
          </li>
        </ul>
      </div>
      <div v-else class="list-empty">
        <div class="empty"><h2>您的商品列表还是空的！</h2></div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data(){
    return{
      message:"",
      commodityList:[],
      busID:"1",
      shop:"",
      temp:"",
      tupian:"",
      seller:"",
      isBusiness:true,
      a:""
    }
  },
  methods:{
    updateMessage(){
      let formDataUpdate=new FormData()
      formDataUpdate.append("ID","1")
      formDataUpdate.append("id",this.busID)
      formDataUpdate.append("eMail",this.message.eMail)
      formDataUpdate.append("phoneNumber",this.message.phoneNumber)
      formDataUpdate.append("name",this.message.name)
      axios.post("http://localhost:8080/api/seller/update",formDataUpdate).then(res=>{
        if(res.data===1)
        {
          alert('成功')
        }
      })
    }
  },
  created() {
    let formdatauser=new FormData()
    formdatauser.append("userId",this.$store.state.user.id)
    axios.post("http://localhost:8080/api//jurisdiction/check",formdatauser).then(async res=>{
      console.log(res.data)
      if(res.data.sellerPower>0)
      {
        console.log(res.data)
        let formDataget=new FormData()
        formDataget.append("sellerId",res.data.sellerPower)
        await axios.post("http://localhost:8080/api/commodity/getAllCommodityBySellerId",formDataget).then(async res=>{
          this.shop=res.data
          for(let i=0;i<this.shop.length;i++)
          {

            let formDataProduct = new FormData();
            formDataProduct.append('id', this.shop[i].id);
            await axios.post("http://localhost:8080/api/commodity/check2", formDataProduct).then(res=>{
              this.temp=this.shop[i]
              this.temp.adress=res.data.description
              console.log(res.data.description)
              this.commodityList.push(this.temp)
            });
            formDataProduct.delete('id')
          }
        })
        let formdataSeller=new FormData();
        formdataSeller.append("ID","1");
        formdataSeller.append("sellerId",res.data.sellerPower);
        axios.post("http://localhost:8080/api/seller/get",formdataSeller).then(res=>{
          this.message=res.data
          this.a=res.data.score
        })

      }
      else
      {
        alert("您不是商家")
        this.$router.replace('/')
      }
    })


  }
}
</script>

<style scoped>
.business{
  background-color: #f5f5f5;
  padding-bottom: 20px;
}
.business .header{
  height: 64px;
  border-bottom: 2px solid #409eff;
  background-color: #fff;
  margin-bottom: 20px;
}
.business .header .content{
  width: 1500px;
  margin: 0 auto;
}
.business .header .content p{
  font-size: 28px;
  line-height: 45px;
  float: left;
  font-weight: normal;
  color: #424242;
}
.business .header span{
  color: #757575;
  font-size: 12px;
  float: right;
  height: 30px;
  line-height: 5px;
  margin-top: 30px;
  margin-left: 15px;
}

.business .list{
  width: 1225px;
  margin: 0 auto;
  background-color: #fff;
}

.business .list ul{
  background-color: #fff;
  color: #424242;
  line-height: 150px;
}
/* 购物车表头及CSS */
.business .list ul .list-header{
  height: 150px;
  padding-right: 26px;
  color: #424242;
}

.business .list ul .bus-img{
  float: left;
  width: 200px;
  height: 100px;
}
.business .list ul .bus-img img {
  height: 100px;
  width: 100px;
}
.business .list ul .bus-name{
  float: left;
  width: 200px;
}
.business .list ul .bus-name a{
  color: #424242;
}
.business .list ul .bus-price{
  float: left;
  width: 140px;
  padding-right: 18px;

}
.business .list ul .bus-discount{
  float: left;
  width: 200px;
  padding-right: 18px;

}
.business .list ul .bus-inventory{
  float: left;
  width: 200px;
  padding-right: 18px;

}
.notBusiness {
  background-color: #f5f5f5;
  padding-bottom: 20px;
}
.notBusiness p{
font-size: 100px;
  line-height: 100px;
}
</style>