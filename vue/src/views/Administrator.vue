<template>
  <div style="display: flex">
    <div style="display: block">
      <el-row class="tac">
        <el-col :span="4">
          <el-menu
              class="el-menu-vertical"
              background-color="#545c64"
              text-color="#fff"
              active-text-color="#ffd04b">
            <el-submenu index="1">
              <el-menu-item-group>
                <el-menu-item index="1-1" @click="gotoAdd">添加商品信息</el-menu-item>
                <el-menu-item index="1-2" @click="gotoDelete">删除商品信息</el-menu-item>
                <el-menu-item index="1-3" @click="gotoPermissions">用户权限管理</el-menu-item>
              </el-menu-item-group>
            </el-submenu>
            <div class="navBottom"></div>
          </el-menu>
        </el-col>
      </el-row>
    </div>

    <router-view style="display: block; width: auto"></router-view>
  </div>
</template>

<script>
export default {
  name: "Administrator",
  methods:{
    gotoAdd(){
      this.$router.replace('/administrator/add')
    },
    gotoDelete(){
      this.$router.replace('/administrator/delete')
    },
    gotoPermissions(){
      this.$router.replace('/administrator/permissions')
    }
  }
}
</script>

<style scoped>
.el-menu-vertical{
  width: 250px;
}
.navBottom{
  height: 498px;
}
</style>