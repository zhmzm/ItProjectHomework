<template>
<div class="comment">
  <div class="header">
   <div class="content">
      <p>商品</p>
      <span>评分<el-rate
          v-model="this.score"
          disabled
          show-score
          text-color="#ff9900"
          score-template="{value}">
         </el-rate></span>

   </div>

</div>
  <div class="list">
    <ul>
      <li class="list-header">
        <div class="tuib">
          <i class="el-icon-chat-line-square">我也要评论</i>
        </div>
        <div class="gopingf">
          <p> </p>
          <el-input
              type="textarea"
              :rows="4"
              placeholder="请输入内容"
              v-model="textarea">
          </el-input>
          <el-button type="primary" plain @click="addComment()">发表评论</el-button>
        </div>
        <div class="pingji">
          <p> </p>
          <el-rate
              v-model="this.scorea"
              show-score
              text-color="#ff9900"
              score-template="{value}">
          </el-rate>
        </div>
      </li>
      <li> </li>
      <li class="clist" v-for="item in commentlist">
        <div class="comm-name">
          <i class="el-icon-user">{{item.name}}</i>
          <el-rate
              v-model="item.score"
              disabled
              show-score
              text-color="#ff9900"
              score-template="{value}">
          </el-rate>
          <p>{{item.time}}</p>
        </div>
        <div>
          {{item.content}}
        </div>
      </li>
    </ul>
  </div>
</div>
</template>

<script>
import axios from "../axios/axios";

export default {
  name: "Comments",
  data(){
    return{
      score:3,
      shop:"",
      value:"saca",
      scorea:2,
      commentlist:[],
      sid:"1",
      them:'',
      textarea:"",
    }
  },
  methods:{
    addComment(){
      let formdataaddcomment=new FormData()
      formdataaddcomment.append("userId",this.$store.state.user.id);
      formdataaddcomment.append("commodityId",this.$route.query.id);
      formdataaddcomment.append("content",this.textarea);
      formdataaddcomment.append("score",this.scorea);
      axios.post("/comments/add",formdataaddcomment).then(res=>{
        if(res.data===1) {
          alert('成功')
        }
      })
    }
  },
  created() {
    let formdatacomment=new FormData()
    console.log(this.$route.query.id)
    formdatacomment.append("commodityId", this.$route.query.id)
    axios.post("/comments/checkByCommodity",formdatacomment).then( async res=>{
      this.shop=res.data
      console.log(this.shop)
      for(let i=0;i<this.shop.length;i++)
      {
        let formDataProduct = new FormData();
        formDataProduct.append('userId',this.shop[i].userId);
        await axios.post("/userInfo/checkInfo", formDataProduct).then(res=>{
          this.them=this.shop[i]
          this.them.name=res.data.name
          this.commentlist.push(this.them)
        });
        formDataProduct.delete("userId")
      }
    })
  }
}
</script>

<style scoped>.comment {
  background-color: #f5f5f5;
  padding-bottom: 20px;
}
.comment .inputComment {
  border-radius: 4px
}

.comment .header{
  height: 64px;
  border-bottom: 2px solid #409eff;
  background-color: #fff;
  margin-bottom: 20px;
}
.comment .header .content{
  width: 1500px;
  margin: 0 auto;
}
.comment .header .content p{
  font-size: 25px;
  line-height: 45px;
  float: left;
  font-weight: normal;
  color: #424242;
}
.comment .header span{
  color: #757575;
  font-size: 12px;
  float: left;
  height: 30px;
  line-height: 5px;
  margin-top: 30px;
  margin-left: 15px;
}

.comment .list{
  width: 1225px;
  margin: 0 auto;
  background-color: #fff;
}

.comment .list ul{
  background-color: #fff;
  color: #424242;
  line-height: 85px;
}

.comment .list ul .list-header{
  height: 180px;
  padding-right: 26px;
  color: #424242;
}
.comment .list ul .clist{
  height: 230px;
  padding-right: 26px;
  color: #424242;
}
.comment .list ul .list-header .tuib{
  float:left;
  width: 200px;
  color:#409eff;
}
.comment .list ul .list-header .pingji{
  float:right;
  height: 100px;
}
.comment .list ul .list-header .gopingf{
  float:left;
  width: 800px;
}
.comment .list ul .list-header .pingji p{
  height: 10px;
}
.comment .list ul .list-header .gopingf p{
  height: 1px;
}
.comment .list ul .clist .comm-name{
  float:left;
  withed:300px;
}
.comment .list ul .clist .comm-name p{
width:500px;
}
</style>