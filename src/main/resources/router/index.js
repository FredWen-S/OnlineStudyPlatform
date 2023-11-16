import Vue from 'vue';
import VueRouter from 'vue-router';

Vue.use(VueRouter);

import Home from '../views/Home.vue';
import Dashboard from '../views/Dashboard.vue';
import MaterialList from '../components/Materials/MaterialList.vue';
import UploadMaterial from '../components/Materials/UploadMaterial.vue';
import Login from '../components/Auth/Login.vue';
import Register from '../components/Auth/Register.vue';
// 导入其他视图组件

const routes = [
    {
        path: '/',
        name: 'Home',
        component: Home
    },
    {
        path: '/login',
        name: 'Login',
        component: Login
    },
    {
        path: '/register',
        name: 'Register',
        component: Register
    },
    {
        path: '/dashboard',
        name: 'Dashboard',
        component: Dashboard
    },
    {
        path: '/materials',
        name: 'MaterialList',
        component: MaterialList
    },
    {
        path: '/upload',
        name: 'UploadMaterial',
        component: UploadMaterial
    },
];

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
});

export default router;
