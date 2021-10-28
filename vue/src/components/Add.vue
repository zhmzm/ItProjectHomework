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
            action="#"
            accept="image/png,image/gif,image/jpg,image/jpeg"
            list-type="picture-card"
            :limit=limitNum
            :auto-upload="false"
            :on-exceed="handleExceed"
            :before-upload="handleBeforeUpload"
            :on-preview="handlePictureCardPreview"
            :on-remove="handleRemove">
          <i class="el-icon-plus"></i>
        </el-upload>
        <el-dialog :visible.sync="dialogVisible">
          <img width="100%" :src="dialogImageUrl" alt="">
        </el-dialog>
      </el-form-item>
      <el-form-item>
        <el-button size="small" type="primary" @click="postToDatabase">立即上传</el-button>
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
      successPostDialog: false,
      dialogImageUrl: '',
      dialogVisible: false,
      formLabelWidth: '80px',
      limitNum: 3,
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
      let size = file.size / 1024 / 1024 / 2
      if(size > 2) {
        this.$notify.warning({
          title: '警告',
          message: '图片大小必须小于2M'
        })
      }
    },
    // 文件超出个数限制时的钩子
    handleExceed(files, fileList) {

    },
    // 文件列表移除文件时的钩子
    handleRemove(file, fileList) {
      console.log(file, fileList);
    },
    // 点击文件列表中已上传的文件时的钩子
    handlePictureCardPreview(file) {
      this.dialogImageUrl = file.url;
      this.dialogVisible = true;
    },
    postToDatabase() {
      let formData = new FormData();
      formData.append('description', this.form.description)
      formData.append('discount', parseFloat(this.form.discount))
      formData.append('inventory', parseInt(this.form.inventory))
      formData.append('name', this.form.name)
      formData.append('prise', parseFloat(this.form.price))
      formData.append('sellerId','1')
      axios.post("http://localhost:8080/api/commodity/add", formData).then(res => {
        if(res.data === 1){

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