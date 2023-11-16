import Vue from 'vue';
import Vuex from 'vuex';
import axios from 'axios';

Vue.use(Vuex);

export default new Vuex.Store({
    state: {
        isLoggedIn: false,
        userData: null,
        materials: [],
        classes: []
    },
    getters: {
        isLoggedIn: state => state.isLoggedIn,
        getUserData: state => state.userData,
        getMaterials: state => state.materials,
        getClasses: state => state.classes
    },
    mutations: {
        setLoggedIn(state, value) {
            state.isLoggedIn = value;
        },
        setUserData(state, data) {
            state.userData = data;
        },
        setMaterials(state, materials) {
            state.materials = materials;
        },
        setClasses(state, classes) {
            state.classes = classes;
        }
    },
    actions: {
        fetchMaterials({ commit }) {
            axios.get('/api/materials')
                .then(response => {
                    const materials = response.data;
                    commit('setMaterials', materials);
                })
                .catch(error => {
                    console.error('Failed to fetch materials', error);
                });
        },
        fetchClasses({ commit }) {
            axios.get('/api/classes')
                .then(response => {
                    const classes = response.data;
                    commit('setClasses', classes);
                })
                .catch(error => {
                    console.error('Failed to fetch classes', error);
                });
        }
    }
});
