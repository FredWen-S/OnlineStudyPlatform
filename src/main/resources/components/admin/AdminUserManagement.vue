<template>
  <div>
    <h1>Admin User Management</h1>
    <!-- 显示用户列表 -->
    <ul>
      <li v-for="user in userList" :key="user.id">
        {{ user.name }} - {{ user.role }}
        <button @click="editUser(user)">Edit</button>
        <button @click="deleteUser(user.id)">Delete</button>
      </li>
    </ul>
    <!-- 添加新用户的表单 -->
    <form @submit.prevent="addUser">
      <input type="text" v-model="newUser.name" placeholder="Name">
      <input type="text" v-model="newUser.role" placeholder="Role">
      <button type="submit">Add User</button>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      userList: [], // 存储用户列表
      newUser: { name: '', role: '' } // 新用户数据
    };
  },
  methods: {
    fetchUserList() {
      axios.get('/api/users')
          .then(response => {
            this.userList = response.data;
          })
          .catch(error => {
            console.error('Error fetching user list: ', error);
          });
    },
    addUser() {
      axios.post('/api/users', this.newUser)
          .then(response => {
            this.userList.push(response.data);
            this.newUser = { name: '', role: '' };
          })
          .catch(error => {
            console.error('Error adding user: ', error);
          });
    },
    editUser(user) {
      // 编辑用户的逻辑，使用axios.put发送更新用户请求
    },
    deleteUser(userId) {
      axios.delete(`/api/users/${userId}`)
          .then(() => {
            this.userList = this.userList.filter(user => user.id !== userId);
          })
          .catch(error => {
            console.error('Error deleting user: ', error);
          });
    }
  },
  created() {
    this.fetchUserList(); // 初始化时获取用户列表
  }
};
</script>

<style>
/* 样式 */
</style>
