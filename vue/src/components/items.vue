<template>
	<div calss="items" v-for="item,index in item_detail">
		<img class="item_img" src="http://192.168.137.43/lowIMG/001.jpg"  :alt="item.name">
		<div class="item_detail">
				  <h6>{{item.name}}</h6>
				  <h3>{{item.price}}</h3>
		</div>
		<div><input type="button" @click="request"></div>
	</div>
</template>	

<script>
	import axios from "axios";
	export default {
		name: "items",
	data () {
		return {
		}
	},
	props: {
		items: {
			type: Object

		}
	},
	methods: {
		request() {
			axios.post("http://localhost:8080/api/commodity/shoplist", formData).then(res => {
				console.log(res.data);
			})
		}
	}
}
</script>

<style>
	.item{
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
