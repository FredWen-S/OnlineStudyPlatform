import Vue from 'vue';
import App from './App.vue';
import router from './router'; // 导入路由配置文件
import store from './store'; // 导入Vuex store
import axios from 'axios';

Vue.config.productionTip = false;

// 设置 Axios 的基础 URL
axios.defaults.baseURL = 'http://localhost:3000'; // 根据实际后端服务的地址设置

new Vue({
    router,
    store,
    render: h => h(App),
}).$mount('#app');
