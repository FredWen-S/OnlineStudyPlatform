import Vue from 'vue';
import Vuex from 'vuex';
import axios from 'axios';

Vue.use(Vuex);

export default new Vuex.Store({
    state: {
        // 应用的全局状态
        isLoggedIn: false, // 用户登录状态
        userData: null, // 用户数据
        materials: [], // 教材列表
        classes: [] // 班级列表
    },
    getters: {
        // 获取状态的方法
        isLoggedIn: state => state.isLoggedIn, // 获取登录状态
        getUserData: state => state.userData, // 获取用户数据
        getMaterials: state => state.materials, // 获取教材列表
        getClasses: state => state.classes // 获取班级列表
    },
    mutations: {
        // 更改状态的同步操作
        setLoggedIn(state, value) {
            // 更新登录状态
            state.isLoggedIn = value;
        },
        setUserData(state, data) {
            // 更新用户数据
            state.userData = data;
        },
        setMaterials(state, materials) {
            // 更新教材列表
            state.materials = materials;
        },
        setClasses(state, classes) {
            // 更新班级列表
            state.classes = classes;
        }
    },
    actions: {
        // 异步操作和业务逻辑
        async fetchMaterials({ commit }) {
            try {
                const response = await axios.get('/api/materials');
                const materials = response.data;
                commit('setMaterials', materials);
            } catch (error) {
                console.error('Failed to fetch materials', error);
                // 在这里可以添加其他状态更新，比如设置错误状态
            }
        },
        async fetchClasses({ commit }) {
            try {
                const response = await axios.get('/api/classes');
                const classes = response.data;
                commit('setClasses', classes);
            } catch (error) {
                console.error('Failed to fetch classes', error);
                // 在这里可以添加其他状态更新，比如设置错误状态
            }
        }
        // 可以继续添加其他异步操作和业务逻辑
    }
});
