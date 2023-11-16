const app = Vue.createApp({
    data() {
        return {
            username: '',
            password: '',
            email: '',
            selectedIdentity: '',
            teacherInfo: {
                education: '',
                school: ''
                // 可以添加其他老师信息字段
            },
            studentInfo: {
                schoolName: '',
                grade: ''
                // 可以添加其他学生信息字段
            }
        };
    },
    methods: {
        registerUser() {
            // 这里可以添加注册逻辑，发送数据到后端等
            console.log('User registered!');
            console.log('Username:', this.username);
            console.log('Password:', this.password);
            console.log('Email:', this.email);
            console.log('Selected Identity:', this.selectedIdentity);
            console.log('Teacher Info:', this.teacherInfo);
            console.log('Student Info:', this.studentInfo);
        }
    }
});

app.mount('#app');
