<template>
  <div class="shoppingCart">

    <div class="cart-header">
      <div class="cart-header-content">
        <p>
          <i class="el-icon-shopping-cart-full" style="color:#ff6700; font-weight: 600;"></i>
          我的购物车
        </p>
        <span>温馨提示：产品是否购买成功，以最终下单为准哦，请尽快结算</span>
      </div>
    </div>
    <!--头部-->

    <div class="content" v-if="shoppingCart.length>0">
      <ul>
        <li class="header">
          <div class="pro-check">
            <el-checkbox v-model="checkAll" @change="setAllCheck">全选</el-checkbox>
          </div>
          <div class="pro-img"></div>
          <div class="pro-name">商品名称</div>
          <div class="pro-price">单价</div>
          <div class="pro-num">数量</div>
          <div class="pro-total">小计</div>
          <div class="pro-action">操作</div>
        </li>
        <!--表头-->


        <li class="product-list" v-for="(item,index) in shoppingCart" :key="item.id">
          <div class="pro-check">
            <el-checkbox v-model="item.check" @change="checkChange()"></el-checkbox>
          </div>
          <div class="pro-img">
            <router-link :to="{ path: '/shop/detail', query: {id:item.commodityId} }">
              <img :src="'https://xuenihongzhao.info/'+item.description"/>
            </router-link>
          </div>
          <div class="pro-name">
            <router-link
                :to="{ path: '/shop/detail', query: {id:item.commodityId} }"
            >{{item.name}}</router-link>
          </div>
          <div class="pro-price">{{item.createPrice}}</div>
          <div class="pro-num">
            <el-input-number
                size="small"
                v-model="item.num"
                :min="1"></el-input-number>
          </div>
          <div class="pro-total pro-total-in">{{item.createPrice}}元</div>
          <div class="pro-action">
            <div style="text-align: right; margin: 10px 0 0">
              <el-button type="danger" icon="el-icon-delete" @click="deleteItem(item.id)" circle ></el-button>
            </div>
          </div>
        </li>
      </ul>
      <div style="height:20px;background-color: #f5f5f5"></div>

      <div class="cart-bar">
        <div class="cart-bar-left">
          <span class="sep">|</span>
          <span class="cart-total">
            已选择
            <span class="cart-total-num">{{getCheckNum()}}</span> 件
          </span>
        </div>
        <div>
          <el-button
              type="primary"
              size="mini"
              @click="handleChange"
          >确定修改数量</el-button>
        </div>
        <div class="cart-bar-right">
          <span>
            <span class="total-price-title">合计：</span>
            <span class="total-price">{{getTotalPrice()}}元</span>
          </span>
          

			<el-button   @click="addtoMyorder">去结算</el-button>

        </div>
      </div>

    </div>
  </div>
</template>

<script>

import axios from "axios";
export default {
  data() {
    return {
      checkAll: false,
      isIndeterminate: true,
      userID:"1",
      shop:"",
      tupian:"",
      name:"",
      shoppingCart: []
    }

  },

  created() {
    let formData3=new FormData()
    formData3.append('userId',parseInt(this.$store.state.user.id))
    console.log(this.$store.state.user.id)
    axios.post("/shopCart/getCartList/",formData3).then(async res=>{
      console.log(res.data);
      this.shop=res.data;
      for(let i=0;i<this.shop.length;i++)
      {

        let formDataProduct = new FormData();
        formDataProduct.append('id', this.shop[i].commodityId);
        await axios.post("/commodity/check2", formDataProduct).then(res=>{
          this.temp=this.shop[i]
          this.temp.description=res.data.description
		  this.temp.sellerId = res.data.sellerId
          console.log(res.data.description)
          this.temp.name=res.data.name
          this.temp.check=false
          this.shoppingCart.push(this.temp)
        });
        formDataProduct.delete('id')
      }
    })
  },
  methods: {
    handleCheckAllChange(){
      this.checkAll=true
      for(let i=0;i<this.shoppingCart.length;i++)
      {
        if(this.shoppingCart[i].check===false)
        {
          this.checkAll=false
          return this.checkAll
        }
        return this.checkAll
      }

    },
	
	addtoMyorder()
	    {
			
	      for (let i = 0; i < this.shoppingCart.length; i++)
	      {
			  
	        const temp =this.shoppingCart[i]
	        if(temp.check)
	        {
			  console.log(temp);
	          let formdata=new FormData();
			  console.log(temp.commodityId)
			  console.log(this.shoppingCart[i].commodityId)
	          formdata.append("commodityId",this.shoppingCart[i].commodityId);
	          formdata.append("num",this.shoppingCart[i].num);
	          formdata.append("sellerId",this.shoppingCart[i].sellerId);
	          formdata.append('userId',this.$store.state.user.id)
	          formdata.append("price",this.shoppingCart[i].createPrice);
			  console.log(formdata);
	          axios.post("/order/add/",formdata).then(res=>{
	            if(res.data===1)
	              alert("添加成功")
	          })
	        }
	      }
	        },
	
    setAllCheck()
    {
      this.checkAll=this.handleCheckAllChange()
      if(this.checkAll===false)
      {
        this.checkAll=true
        for(let i=0;i<this.shoppingCart.length;i++)
        {
          this.shoppingCart[i].check=true
        }
      }
      else
      {
        this.checkAll=false
        for(let i=0;i<this.shoppingCart.length;i++) {
          this.shoppingCart[i].check = false
        }
      }
    },

    handleChange()
    {
      for(let i=0;i<this.shoppingCart.length;i++)
      {
        let formDataC=new FormData()
        formDataC.append("id",this.shoppingCart[i].id)
        formDataC.append("num",this.shoppingCart[i].num)
        console.log(this.shoppingCart[i].id)
        axios.post("/shopCart/updateCart",formDataC).then(res=>{
        });
        formDataC.delete("id")
        formDataC.delete("num")
      }

    },
    deleteShoppingCart (id) {
      // 根据购物车id删除购物车商品
      for (let i = 0; i < this.shoppingCart.length; i++) {
        const temp = this.shoppingCart[i];
        if (temp.id === id) {
          this.shoppingCart.splice(i, 1);
        }
      }
    },

    getNum () {
      // 购物车商品总数量
      let totalNum = 0;
      for (let i = 0; i < this.shoppingCart.length; i++) {
        const temp = this.shoppingCart[i];
        totalNum += temp.num;
      }
      return totalNum;
    },
    getCheckNum () {
      // 获取购物车勾选的商品数量
      let totalNum = 0;
      for (let i = 0; i < this.shoppingCart.length; i++) {
        const temp = this.shoppingCart[i];
        if (temp.check) {
          totalNum += temp.num;
        }
      }
      return totalNum;
    },
    getTotalPrice () {
      // 购物车勾选的商品总价格
      let totalPrice = 0;
      for (let i = 0; i < this.shoppingCart.length; i++) {
        const temp = this.shoppingCart[i];
        if (temp.check) {
          totalPrice += temp.createPrice * temp.num;
        }
      }
      return totalPrice;
    },

    checkChange() {
      // 更新vuex中购物车商品是否勾选的状态
      this.checkAll=true
      for(let i=0;i<this.shoppingCart.length;i++)
      {
        if(this.shoppingCart[i].check===false) {
          this.checkAll = false
          console.log(this.checkAll)
        }
      }


    },
    deleteItem(id){
      let formData1=new FormData();
      formData1.append('id',id)
      console.log(id)
      axios.post("/shopCart/delCart",formData1).then(res => {
        if (res.data === 1) {
          this.deleteShoppingCart(id)
          alert('成功')
        } else {
          alert('失败')
        }
      });
    }
  },

}

</script>

<style scoped>
.shoppingCart {
  background-color: #f5f5f5;
  padding-bottom: 20px;
}
/* 购物车头部CSS */
.shoppingCart .cart-header {
  height: 64px;
  border-bottom: 2px solid #ff6700;
  background-color: #fff;
  margin-bottom: 20px;
}
.shoppingCart .cart-header .cart-header-content {
  width: 1500px;
  margin: 0 auto;
}
.shoppingCart .cart-header p {
  font-size: 28px;
  line-height: 40px;
  float: left;
  font-weight: normal;
  color: #424242;
}
.shoppingCart .cart-header span {
  color: #757575;
  font-size: 12px;
  float: left;
  height: 20px;
  line-height: 20px;
  margin-top: 30px;
  margin-left: 15px;
}
/* 购物车头部CSS END */

/* 购物车主要内容区CSS */
.shoppingCart .content {
  width: 1225px;
  margin: 0 auto;
  background-color: #fff;
}

.shoppingCart .content ul {
  background-color: #fff;
  color: #424242;
  line-height: 85px;
}
/* 购物车表头及CSS */
.shoppingCart .content ul .header {
  height: 85px;
  padding-right: 26px;
  color: #424242;
}
.shoppingCart .content ul .product-list {
  height: 85px;
  padding: 15px 26px 15px 0;
  border-top: 1px solid #e0e0e0;
}
.shoppingCart .content ul .pro-check {
  float: left;
  height: 85px;
  width: 80px;
}
.shoppingCart .content ul .pro-check .el-checkbox {
  font-size: 16px;
  margin-left: 24px;
}
.shoppingCart .content ul .pro-img {
  float: left;
  height: 85px;
  width: 100px;
}
.shoppingCart .content ul .pro-img img {
  height: 80px;
  width: 80px;
}
.shoppingCart .content ul .pro-name {
  float: left;
  width: 200px;
}
.shoppingCart .content ul .pro-name a {
  color: #424242;
}
.shoppingCart .content ul .pro-name a:hover {
  color: #ff6700;
}
.shoppingCart .content ul .pro-price {
  float: left;
  width: 140px;
  padding-right: 18px;
  text-align: center;
}
.shoppingCart .content ul .pro-num {
  float: left;
  width: 150px;
  text-align: center;
}
.shoppingCart .content ul .pro-total {
  float: left;
  width: 120px;
  padding-right: 81px;
  text-align: right;
}
.shoppingCart .content ul .pro-total-in {
  color: #ff6700;
}
.shoppingCart .content ul .pro-action {
  float: left;
  width: 80px;
  text-align: center;
}
.shoppingCart .content ul .pro-action i:hover {
  color: #ff6700;
}
/* 购物车表头及CSS END */

/* 购物车底部导航条CSS */
.shoppingCart .cart-bar {
  width: 1225px;
  height: 50px;
  line-height: 50px;
  background-color: #fff;
}
.shoppingCart .cart-bar .cart-bar-left {
  float: left;
}
.shoppingCart .cart-bar .cart-bar-left a {
  line-height: 50px;
  margin-left: 32px;
  color: #757575;
}
.shoppingCart .cart-bar .cart-bar-left a:hover {
  color: #ff6700;
}
.shoppingCart .cart-bar .cart-bar-left .sep {
  color: #eee;
  margin: 0 20px;
}
.shoppingCart .cart-bar .cart-bar-left .cart-total {
  color: #757575;
}
.shoppingCart .cart-bar .cart-bar-left .cart-total-num {
  color: #ff6700;
}
.shoppingCart .cart-bar .cart-bar-right {
  float: right;
}
.shoppingCart .cart-bar .cart-bar-right .total-price-title {
  color: #ff6700;
  font-size: 14px;
}
.shoppingCart .cart-bar .cart-bar-right .total-price {
  color: #ff6700;
  font-size: 30px;
}
.shoppingCart .cart-bar .cart-bar-right .btn-primary {
  float: right;
  width: 180px;
  text-align: center;
  font-size: 18px;
  margin-left: 50px;
  background: #ff6700;
  color: #fff;
}
.shoppingCart .cart-bar .cart-bar-right .btn-primary-disabled {
  float: right;
  width: 180px;
  text-align: center;
  font-size: 18px;
  margin-left: 50px;
  background: #e0e0e0;
  color: #b0b0b0;
}
.shoppingCart .cart-bar .cart-bar-right .btn-primary:hover {
  background-color: #f25807;
}
/* 购物车底部导航条CSS END */
/* 购物车主要内容区CSS END */

/* 购物车为空的时候显示的内容CSS */
.shoppingCart .cart-empty {
  width: 1225px;
  margin: 0 auto;
}
</style>