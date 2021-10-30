<template>
  <input type="button" @click="print">print
  <el-form ref="form" :model="form" label-width="80px">
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
  </div>
  <router-view></router-view>

</template>

<script>
import axios from "axios";

export default {
  name: "Shop",
  data() {
    return {
      form: {
        text: '',
      },

      goodsList: [],

      productCounter: 1,

      allID: "",

      temp: [1,2,3],

      allProduct: []

    }
  },
  methods: {
    addGood() {
      this.goodsList.push({
        productID: this.productCounter,
        productText: this.form.text
      })
      this.productCounter += 1
    },
    print(){
      console.log(this.allID);
      console.log(this.allID.length);
    }
  },

  created :function() {
    axios.post("http://localhost:8080/api/commodity/shoplist").then(res =>{
      this.allID = res.data;
      console.log(this.allID);
      console.log(this.allID.length);
      for(let i = 0; i < this.allID.length; i++){
        let formData = new FormData();
        formData.append('id', this.allID[i]);
        axios.post("http://localhost:8080/api/commodity/check", formData).then(res =>{
          this.allProduct.push(res.data);
        })
        formData.delete('id');
      }
    });


    console.log(this.allID);
    console.log(this.allID.length);
  },
}

</script>

<style scoped>
.goodItem{
  width: 250px;
  height: 150px;
  display: inline-block;
  margin: 30px 30px 30px 30px;
  border: 1px solid #0d0d0d;
  float: left;
}
</style>