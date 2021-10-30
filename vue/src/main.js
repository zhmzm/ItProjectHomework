import { createApp } from 'vue'
import App from './App.vue'
//引入路由
import router from './router'
//引入vuex
import store from './store/index'
//引入ElementPlus
import ElementPlus from 'element-plus'
//引入样式
import 'element-plus/dist/index.css'




const app =createApp(App)
app.use(ElementPlus)
app.use(store)
app.use(router)
app.mount('#app')




