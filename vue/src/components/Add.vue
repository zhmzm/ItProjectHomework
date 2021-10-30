<template>
  <div style="margin-top: 50px">
    <el-form ref="form" label-width="200px">
      <el-form-item label="商品名称">
        <el-input class="input" v-model="form.name"></el-input>
      </el-form-item>
      <el-form-item label="商品介绍">
        <el-input type="textarea" class="input" v-model="form.description"></el-input>
      </el-form-item>
      <el-form-item label="原价">
        <el-input type="input"  v-model="form.price"></el-input>
      </el-form-item>
      <el-form-item label="折扣">
        <el-input type="input"  v-model="form.discount"></el-input>
      </el-form-item>
      <el-form-item label="库存">
        <el-input type="input"  v-model="form.inventory"></el-input>
      </el-form-item>
      <el-form-item>
      </el-form-item>

      <el-form-item label="商品图片" :label-width="formLabelWidth" style="margin-left: 120px">
        <el-upload
            ref="upload"
            action="http://localhost:8080/api/file/CommodityImg"
            accept="image/png,image/gif,image/jpg,image/jpeg"
            list-type="picture-card"
            :auto-upload="false"
            :before-upload="handleBeforeUpload">
          <i class="el-icon-plus"></i>
        </el-upload>


      </el-form-item>
      <el-form-item>
        <el-button size="small" type="primary" @click="postToDatabase">立即上传</el-button>
          <el-dialog
            title="提示"
            v-model="afterDialogVisible"
            :visible.sync="afterDialogVisible"
            width="30%">
            <div style="margin-bottom: 30px">添加成功</div>
            <span slot="footer" class="dialog-footer">
            <el-button type="primary" @click="afterClick">确 定</el-button>
            <el-button @click="afterClick">取 消</el-button>
            </span>
          </el-dialog>
        <el-button size="small">取消</el-button>
      </el-form-item>
    </el-form>
  </div>

</template>

<script>
import axios from "axios";

export default {
  name: "Add",
  data() {
    return {
      afterDialogVisible: false,
      formLabelWidth: '80px',
      form: {
        name: '',
        description: '',
        discount: '',
        inventory: '',
        price: '',
      }
      }
    },
  methods: {
    // 上传文件之前的钩子
    handleBeforeUpload(file){
      console.log('before')
      if(!(file.type === 'image/png' || file.type === 'image/gif' || file.type === 'image/jpg' || file.type === 'image/jpeg')) {
        this.$notify.warning({
          title: '警告',
          message: '请上传格式为image/png, image/gif, image/jpg, image/jpeg的图片'
        })
      }
    },


    postToDatabase() {
      this.$refs.upload.submit();
      this.afterDialogVisible = true;
      let formData = new FormData();
      formData.append('description', this.form.description)
      formData.append('discount', parseFloat(this.form.discount))
      formData.append('inventory', parseInt(this.form.inventory))
      formData.append('name', this.form.name)
      formData.append('prise', parseFloat(this.form.price))
      formData.append('sellerId','1')
      axios.post("http://localhost:8080/api/commodity/add", formData).then(res => {

      })
    },
    afterClick(){
      this.afterDialogVisible = false;
      location.reload();
    },

  },
  created: function () {
    if(this.$store.state.login === 0){
      alert('请先登录！');
      this.$router.replace('/administrator');
    }
    else{
      let formData1 = new FormData();
      formData1.append('userId', this.$store.state.user.id.toString())
      axios.post("http://localhost:8080/api/jurisdiction/check", formData1).then(res => {
        if(res.data.sellerPower !== 1 && res.data.administratorPower !== 1){
          alert('您没有权限进入此界面。');
          this.$router.replace('/administrator');
        }
      })
    }
  }
}
</script>

<style scoped>
.input{
  width: 800px;
}
</style>