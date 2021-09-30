<template>
  <div class="header_container">
   <!-- <div calss="header_img"><img src="../assets/headerlogo.png" /></div> -->
    <div class="header_search">
      <div>
        <input type="text" placeholder="搜索商品名称" v-model="keywords" />
        <el-button type="danger" icon="el-icon-search" @click="postSearch"></el-button>
       </div>
    </div>
  </div>

<div class="clearfix">
  <ul class="item_list">
    <el-button class="item">
      <img class="item_img" src="../assets/phone.png" alt="">
      <div class="item_detail">手机</div>
    </el-button>
    <el-button class="item"></el-button>
    <el-button class="item"></el-button>
    <el-button class="item"></el-button>
    <el-button class="item"></el-button>
    <el-button class="item"></el-button>
    <el-button class="item"></el-button>
  </ul>
</div>
  <!-- <el-form ref="form" :model="form" label-width="auto">
    <el-form-item label="商品介绍" style="margin: 10px 10px 10px 10px;">
      <el-input type="textarea" v-model="form.text"></el-input>
    </el-form-item>
    <el-button type="primary" @click="addGood" style="display: inline-block">添加</el-button>
  </el-form>

  <div v-for="good in goodsList" class="goodItem" :key="good.productID">
    <router-link :to="{ path: '/shop/detail', query: {id: good.productID} }" >
      <div>商品编号：{{good.productID}}</div>
      <div>商品描述：{{good.productText}}</div>
    </router-link>
  </div> -->
  <router-view></router-view>

</template>

<script>
export default {
  name: "Shop",
  data() {
    return {
      keywords: ""
      }
      // goodsList: [],
      // productCounter: 0
}
  // methods: {
  //   addGood() {
  //     this.goodsList.push({
  //       productID: this.productCounter,
  //       productText: this.form.text
  //     })
  //     this.productCounter += 1
  //   },
  // },
}

</script>

<style >
/* .goodItem{
  width: 250px;
  height: 150px;
  display: inline-block;
  margin: 30px 30px 30px 30px;
  border: 1px solid #0d0d0d;
  float: left;
} */

/*头部搜索区*/
.header_container{
	position: relative;
	width: 100%;
  height: 100px;
  margin: 0;
  padding: 0;
}

/*商城标识图片区域*/
/* .header_container>.header_img{
	position: absolute;
	left: 100px;
	margin-top: 10px;
	width: 40px;
	height: 40px;
  border: 1px solid darkgray;
  box-shadow: 2px 4px 15px rgba(45,45,45,0.15);
  border-radius: 20%;
}
.header_img>img{
  position: absolute;
	width: 10px;
	height: 10px;
} */

.header_search{
	position: absolute;
	left: 50%;
	margin-left: -290px;
	margin-top: 50px;
}
.header_search div{
  display: flex;
  align-items: center;
}
.header_search input{
	padding-left: 10px;
	width: 490px;
	height: 35px;
	font-size: 14px;
	line-height: 35px;
	border: 2px solid #409eff;
  border-right: none;
	outline: none;
}
.header_search button.el-button.el-button--danger{
  padding: 0;
  width: 60px;
  height: 35px;
	font-size: 18px;
  border-radius: 0;
  outline: none;
  display: flex;
  justify-content: center;
  align-items: center;
}
.header_search>p>a{
	display: inline-block;
	padding: 5px 10px;
	font-size: 12px;
	color: #999;
	cursor: pointer;
}
.header_search>p>a:hover{
	color: blue;
}
.item_list{
  position: relative;
  width: 97%;
  height: 2500px;
  font-size: 0;
  border: 1px solid #409eff;
  display:grid;
  grid-template-columns: auto auto auto auto;
  grid-gap: 10px;
  padding: 10px;
}
.item_list>.item{
  position: relative;
      width: 236px;
      height: 368px;
      box-sizing: border-box;
      font-size: 12px;
      border: 1px solid #000000;
      background: #fff;
      text-align: center;
      margin: 20px 20px 20px 20px;
}
.clearfix::after {
  content: "";
  clear: both;
  display: table;
}
.item_img{
  width: 100%;
  height: 250px;
  vertical-align: top;
}
.item_detail{
  overflow: hidden;
  width: 100%;
  height: 50px;
  padding-bottom: 20px;
  text-align: center;
  font-size: 20px;
}
</style>
