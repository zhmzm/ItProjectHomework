<template>
	<!-- //页面顶部 -->
  <div class="header_container">
    <div class="header_search">
      <div>
        <input type="text" placeholder="搜索商品名称" v-model="keywords" />
        <el-button type="primary" icon="el-icon-search"  :loading="true"></el-button>
       </div>
    </div>
  </div>
  
 <!-- //页面body -->
   <el-main class="item_list">
	   	<div class="background"></div>
	   <el-button class="item" v-for="item in this.allItem"  shadow="hover">
		   <router-link :to="{path:'/shop/detail', query:{id:item.id}}">
		   <div>
         <img class="item_img"  :src="'https://xuenihongzhao.info/' + item.address"/>
		   </div>
	   		 <div class="item_detail">
	   				<p>{{item.name}}</p>
	   				<p>{{item.prise}}</p>
	   		 </div>
			 </router-link>
	   </el-button>
   </el-main>
   
 <!--  //页面底部
   //分页 -->
 <el-pagination     
 background     
 layout="prev, pager, next"        
 :total="50"
 :page-size="pageSize"
 @current-change="currentChange"
 > 
 </el-pagination>
  <router-view></router-view>
</template>

<script>
import axios from "../axios/axios"	

export default {
  name: "Shop",
  data() {
    return {
	allID: [],
	keywords: "",
	allItem: [],  //所有商品的数据
	tempObj: ""   ,//用来存放取出的一个属性
	
	
	
	pageSize: 20, // 每页显示的商品数量
	currentPage: 1, //当前页码
	}
  },
  methods:{
	
  },

  created () {
    axios.post("/commodity/shoplist").then(async res =>{
         this.allID = res.data;
           for(let i = 0; i < this.allID.length; i++){
			 
			 //请求商品信息数据
           let formDataDetail = new FormData();
           formDataDetail.append('id', this.allID[i]);
            await axios.post("/commodity/check", formDataDetail).then(res =>{
			      this.tempObj = res.data;
           });
           formDataDetail.delete('id');
		   
		   //请求图片数据
		   let formDataPhoto = new FormData();
		   formDataPhoto.append('commodityID', this.allID[i]);
        await axios.post("/commodity/photo", formDataPhoto).then(res =>{
				this.tempObj.address = res.data[0].address;
				this.allItem.push(this.tempObj);
          console.log(res.data[0].address)
		   });
		   formDataPhoto.delete('commodityID');
         }

       });
 },
 
 
 
 
 
 
 
 }
 
</script>

<style >
/*头部搜索区*/
.header_container{
/* 	position: relative; */
	width: 100%;
  height: 100px;
  margin: 0;
  padding: 0;
}

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
.header_search button.el-button.el-button--primary{
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



/* 商品展示区样式 */
.item_list{
  position: relative;
  line-width: 96%;
  height: 2500px;
  font-size: 10px;
  border: 1px solid #409eff;
  display:grid;
  text-align: center;
  grid-template-columns: auto auto auto auto;
  grid-gap: 10px;
  padding: 10px;
}
.item_list>.background{
	background: url(../assets/background.png) no-repeat;
	  background-position: center;
	  height: 100%;
	  width: 100%;
	  background-size: cover;
	  position:absolute;
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
	  text-decoration: none;
}

.item_img{
  width: 100%;
  height: 230px;
  vertical-align: top;
}
.item_detail{
  overflow: hidden;
  width: 100%;
  height: 100px;
  padding-bottom: 0px;
  text-align: center;
  font-size: 20px;
  text-overflow: ellipsis;
  white-space: nowrap;
  text-decoration: none;
}

.router-link-active {
  text-decoration: none;
}

a{
	text-decoration: none;
}
</style>




