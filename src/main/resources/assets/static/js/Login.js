// 例如，你可以创建一个名为 `login.js` 的文件
// login.js

const app = Vue.createApp({
    data() {
        return {
            username: '',
            password: ''
        };
    },
    methods: {
        login() {
            // Add login functionality here
            console.log('Logging in...');
        }
    }
});

app.mount('#app');
