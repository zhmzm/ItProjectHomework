<template>
	<el-container>
		<el-header>
			<p><i class="el-icon-s-order" style=" color: #409eff;"></i>
			<strong>我的订单</strong>
			</p>	
		</el-header>
		<el-main>
			<div class="order-content" v-for="item in this.myorder">
				<ul>
					<li class="order-info">
						<div class="order-id">订单编号：{{item.id}}</div>
						<div class="order-time">订单时间：{{item.time}}</div>
					</li>
				</ul>	
				<el-descriptions
				    direction="vertical"
					:column="5"
					border
				>
				<el-descriptions-item class="pro-img" ><img src=""></el-descriptions-item>
				<el-descriptions-item class="pro-name" label="商品名称">{{item.commodityId}}</el-descriptions-item>
				<el-descriptions-item class="pro-price" label="单价">{{item.price}}</el-descriptions-item>
				<el-descriptions-item class="pro-num" label="数量">{{item.num}}</el-descriptions-item>
				<el-descriptions-item class="pro-total" label="小计">{{this.prototal}}</el-descriptions-item>
				</el-descriptions>
				<div class="order-bar">
					<div class="order-total-num">
						<span>共 {{item.totalnum}} 件商品</span>
					</div>
					<div class="order-total-price">
						<span>合计： {{item.totalprice}}</span>
					</div>
				</div>	
			</div>
		</el-main>
		<el-footer>
			<el-pagination
			background     
			layout="prev, pager, next"        
			:total="50"
			:page-size="pageSize"
			@current-change="currentChange"
			> 
			</el-pagination>
		</el-footer>
	</el-container>
	<router-view></router-view>
</template>

<script>
	import axios from "axios"
	
	export default{
		name: "Myorder",
		data(){
			return{
				myorder: [],
				prototal: '',
				totalprice: '',
				totalnum: '',
				userId: '',
			}
		},
		
	computed:{
			prototal:function(){
				return Number(this.myorder.price)*Number(this.myorder.num)
			},
			// totalprice:function(){
			// 	return += Number(this.prototal)
			// },
			// totalnum:function(){
			// 	return += Number(myorder.num)
			// },
		},
	
	created () {
		let formdata = new FormData();
		formdata.append('UserId',this.$store.state.user.id)
	 axios.post("http://localhost:8080/api/order/getIdByUserId/",formdata).then(res =>{
			this.myorder = res.data;
			console.log(this.myorder);
		})
}


}

</script>

<style>
	.el-header p{
		font-size: 28px;
		line-height: 58px;
		float: left;
		font-weight: 400;
		display: block;
	}
	
	.el-main {
	  background-color: #e9eef3;
	  color: var(--el-text-color-primary);
	  text-align: center;
	  height: 900px;
	  margin-top: 50px;
	}

	.order-bar{
		height: 40px;
		background-color:#fff;
	}

	
	.order-id{
		float: left;
	}
	
	.order-time{
		float: right;
	}
	
	.el-footer {
	  background-color: #b3c0d1;
	  color: var(--el-text-color-primary);
	  text-align: center;
	  line-height: 60px;
	}
	
	.order-content{
		width: 95%;
		height:300px;
		background-color:#fff;
		margin-bottom: 50px;
		margin: auto;
		box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
	}
	
	.el-descriptions{
		height: 210px;
	}
	
	.el-descriptions__cell{
		height: 100px;
	}

.order-total-num{
		float: left;
	}
	
	.order-total-price{
		float: right;
	}
</style>