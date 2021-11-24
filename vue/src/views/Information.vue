<template>
	<el-container>
		<el-aside width="200px">
			<el-avatar shape="circle" :size="100">
				<img :src=" 'https://xuenihongzhao.info/'  + allInformation.photo"  style="width: 100%;  height: 100%;">
			</el-avatar>
			<el-upload
			    ref="upload"
				action="/file/personalImg"
				accept="image/png,image/jpg,image/jpeg"
				:show-file-list="false"
				:before-upload="handleBeforeUpload"
				:on-success="success"
				
			>
				<el-button type="primary" size="mini"  plain> 更换头像 </el-button>
			</el-upload>
			
			<div style="margin-top: 80px;">
				ID : {{allInformation.account}}
			</div>
		</el-aside>
	<el-main>
		<div style="float: left;color:#409eff ;font-size: 30px;">Information</div>
		<el-form >
			<el-form-item>
				<template #label >
					<i class="el-icon-user"></i>
					Username
				</template>
					<el-input autocomplete="off" v-model="allInformation.name" type="text"  row="2"
						maxlength="20" validateevent="true"></el-input>
		    </el-form-item>
            <el-form-item>
		    	<template #label >
		    	       <i class="el-icon-mobile-phone"></i>
		    	       Telephone
		    	</template>
				        <el-input autocomplete="off"  v-model="allInformation.phoneNumber" type="text"  row="2"
		    			maxlength="20" validateevent="true"></el-input>
			</el-form-item>			
            <el-form-item>
		    	<template #label>
		    	       <i class="el-icon-tickets"></i>
		    	       EMail
		    	     </template>
					 <el-input autocomplete="off"  v-model="allInformation.eMail"  type="text"  row="2"
		    			maxlength="20" validateevent="true" ></el-input>
			</el-form-item>			
            <el-form-item>
		    	<template #label>
		    	        <i class="el-icon-office-building"></i>
		    	        Address
		    	      </template>
                       <el-input autocomplete="off"  v-model="allInformation.address"  type="text"  row="2"
		    			maxlength="20" validateevent="true"></el-input>
			</el-form-item>
			<el-form-item>
				<template #label>
				        <i class="el-icon-lock"></i>
				        Password
				      </template>
			           <el-input autocomplete="off"  v-model="allInformation.password"  type="text"  row="2"
						maxlength="20" validateevent="true"></el-input>
			</el-form-item>			
		</el-form>
		<div class="padding-dom"></div>
	     <el-button type="primary" @click="EditUserInfo" style="margin-top: 10px;"> 保存 </el-button>
     </el-main>
	</el-container>
	
	<router-view></router-view>
</template>

<script>
import axios from "../axios/axios"

export default{
	name: "Information",
	data(){
		return{
			allInformation:{},
			size: '',
		    Newphoto: '',
			userId: '',
		}
	},
	methods:{
		EditUserInfo(){
			let formdata = new FormData();
			formdata.append("account", this.allInformation.account)
			formdata.append("salt", this.allInformation.salt);
			formdata.append("address", this.allInformation.address);
			formdata.append("eMail", this.allInformation.eMail);
			formdata.append("id", this.allInformation.id);
			formdata.append("name", this.allInformation.name);
			formdata.append("password", this.allInformation.password);
			formdata.append("phoneNumber", this.allInformation.phoneNumber);
			formdata.append("photo", this.allInformation.photo);
			axios.post("/userInfo/update", formdata).then(res =>{
				location.reload();
			})
		},

		 // 上传文件之前的钩子
		    handleBeforeUpload(file){
		      console.log('before')
		      if(!(file.type === 'image/png' ||file.type === 'image/jpg' || file.type === 'image/jpeg')) {
		        this.$notify.warning({
		          title: '警告',
		          message: '请上传格式为image/png,image/jpg, image/jpeg的图片'
		        })
		      }
		    },
				
		success(res){
			this.Newphoto = res;
			let formdata = new FormData();
			formdata.append("id", this.allInformation.id);
			formdata.append("photo",this.Newphoto);
		 axios.post("/userInfo/update", formdata).then(res =>{
			// location.reload();
			this.allInformation.photo = this.Newphoto;
			console.log(this.allInformation.photo)
				})
		},
},
	
	
	
	created () {
		let formdata3 = new FormData();
		formdata3.append('userId',this.$store.state.user.id)
		console.log(formdata3);
		console.log(this.$store.state.user);
	 axios.post("/userInfo/checkInfo/",formdata3).then(res =>{
		this.allInformation = res.data;
		console.log(this.allInformation);
		})
	}
}
</script>

<style scoped>
.el-aside {
	  background-color: #d3dce6;
	  color: var(--el-text-color-primary);
	  text-align: center;
	  line-height: 10px;
	  object-fit: fill;
	}
	
.el-aside>>>.el-avatar{
		margin-top: 100px;
	}
.el-aside>>>.el-button{
	margin-top: 10px;
}


.el-main {
	  background-color: #e9eef3;
	  color: var(--el-text-color-primary);
	  text-align: center;
	  height: 900px;
	  position: relative;
	}

.el-form{
	display: block;
	margin-top: 100px;
}

.el-form-item{
	margin-bottom: 50px;	
}

.el-form-item>>>.el-form-item__label {
    font-size: 14px;
    color: #409eff;
    box-sizing: border-box;
	width: 95px;
    text-align: left;
	margin-right: 20px;
	float: left;
	line-height: 30px;
	padding: 0;
}

.padding-dom{
	width: 100%;
	height: 100px;
}

.el-input{
	width: 800px;
	float: left;
	display: inline-block;
	position: relative;
	font-size: 14px;
}

.el-input__inner{
	float: left;
	width: 225px;
	height: 30px;
	margin-right: 40px;
}
</style>
