<template>

  <div class="business">

    <!--  头部-->
    <div class="header">
      <div class="content">
        <p align="left">{{this.message.name}}的商品列表</p>
        <span>评分<el-rate
            v-model="this.message.score"
            disabled
            show-score
            text-color="#ff9900"
            score-template="{value}">
        </el-rate></span>

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
    <div>
      <p>电话号码：{{this.message.phoneNumber}}</p>
      <p>email：{{this.message.eMail}}</p>
      <p>开店时间：{{this.message.registerTime}}</p>
    </div>
  </div>


</template>

<script>
import axios from "../axios/axios";

export default {
data(){
  return{
      commodityList:[],
      busID:"1",
      shop:"",
      temp:"",
      tupian:"",
      seller:"",
      message:"",
    value:3.3
    }
},
  methods:{

  },
created() {
    let formDataget=new FormData()
    formDataget.append("sellerId",  this.$route.query.id)
    axios.post("/commodity/getAllCommodityBySellerId",formDataget).then(async res=>{
      this.shop=res.data
      for(let i=0;i<this.shop.length;i++)
      {

        let formDataProduct = new FormData();
        formDataProduct.append('id', this.shop[i].id);
        await axios.post("/commodity/check2", formDataProduct).then(res=>{
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
      formdataSeller.append("sellerId",this.$route.query.id);
       axios.post("/seller/get",formdataSeller).then(res=>{
        this.message=res.data
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
  width: 1500px;
  margin: 0 auto;
  background-color: #fff;
}

.business .list ul{
  background-color: #fff;
  color: #424242;
  line-height: 85px;
}
/* 购物车表头及CSS */
.business .list ul .list-header{
  height: 100px;
  padding-right: 26px;
  color: #424242;
}
.business .list ul .bus-img{
  float: left;
  width: 150px;
  height: 80px;
}
.business .list ul .bus-img img {
  height: 120px;
  width: 120px;
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
  width: 200px;
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
.business .list ul .Commodities-list{
  height:150px

}
</style>