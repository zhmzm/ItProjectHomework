<template>
  <el-main className="el-main">
    <div className="productImage" v-if="imgURL.length>1">
      <el-carousel height="560px" indicator-position="outside">
        <el-carousel-item v-for="item in imgURL" :key="item">
          <img style="height:560px;" :src="'https://xuenihongzhao.info/' + item.address"/>
        </el-carousel-item>
      </el-carousel>
    </div>

    <div className="content">
      <div className="productName">
        {{ productDetail.name }}
      </div>
      <p className="productText">
        {{ productDetail.description }}
      </p>
      <div className="salePrice">
        <span>打折价:</span>
        <span>{{ productDetail.prise * productDetail.discount }}</span>
      </div>
      <div className="originalPrice">
        <span>售前价:</span>
        <span>{{ productDetail.prise }}</span>
      </div>
      <div className="stock">
        <span>库存:</span>
        <span>{{ productDetail.inventory }}</span>
      </div>
      <div className="horizontalBar"></div>
        <router-link :to="{ path: '/comment', query: {id:productDetail.id} }">
          <el-button type="primary" plain style="margin-right: 90px; width: 100px">查看评论</el-button>
        </router-link>
      <el-button type="primary" plain style="margin-right: 45px; width: 100px" @click="addToShoppingCart">加入购物车</el-button>
      <el-button type="primary" plain style="margin-left: 45px; width: 100px" @click="addtoMyorder">立即购买</el-button>
    </div>
      <router-link :to="{ path: '/business', query: {id:productDetail.sellerId} }">
        <el-button type="primary" plain style="width: 100px">查看商家</el-button>
      </router-link>
  </el-main>

</template>

<script>
import axios from "../axios/axios";

export default {
  name: "Detail",
  data() {
    return {
      productDetail: "",
      imgURL: "",
    }
  },
  methods: {
    addToShoppingCart(){
      let formDataCommodity=new FormData
      formDataCommodity.append("commodityId",this.productDetail.id)
      formDataCommodity.append("createPrice",this.productDetail.prise*this.productDetail.discount)
      formDataCommodity.append("userId",this.$store.state.user.id)
      formDataCommodity.append("num","1")
      axios.post("/shopCart/addCartList",formDataCommodity).then(res=>{
        if(res.data===1)
          alert('成功')
      })
    },
    addtoMyorder(){
      let formdata = new FormData
      formdata.append("commodityId",this.productDetail.id)
      formdata.append("num","1")
      formdata.append("userId",this.$route.query.id)
      formdata.append("price",this.productDetail.prise*this.productDetail.discount)
      formdata.append("sellerId",this.productDetail.sellerId)
      axios.post("/order/add/",formdata).then(res=>{
        if(res.data===1)
          alert("添加成功")
      })
    }
  },
  created: function () {
    let formData1 = new FormData();
    formData1.append('id', this.$route.query.id)
    axios.post("/commodity/check", formData1).then(res => {
        this.productDetail = res.data;
        console.log(res.data);
    })
    let formData2 = new FormData();
    formData2.append('commodityID', this.$route.query.id)
    axios.post("/commodity/photo", formData2).then(res => {
        this.imgURL = res.data;
    })
  }
}
</script>

<style scoped>
.productImage {
  margin-left: 20px;
  height: 560px;
  width: 560px;
}

.content {
  margin-left: 80px;
  width: 650px;
}

.el-main {
  display: flex;
}

.productName {
  margin-top: 20px;
  font-weight: bold;
  font-size: 40px;
}

.productText {
  margin-top: 50px;
  text-align: left;
  color: rgba(19, 19, 19, 0.6);
}

.salePrice {
  margin-top: 50px;
  text-align: left;
  color: #ffae6d;
  font-size: 30px;
}

.originalPrice {
  text-decoration: line-through;
  margin-top: 40px;
  text-align: right;
  color: rgba(19, 19, 19, 0.3);
}

.stock {
  margin-top: 20px;
  text-align: right;
  color: rgba(19, 19, 19, 0.8);
}

.horizontalBar {
  width: 630px;
  height: 28px;
  margin: 0 auto;
  margin-top: 50px;
  border-bottom: 1px solid rgba(19, 19, 19, 0.6);
  margin-bottom: 70px;
  text-align: center;
}
</style>