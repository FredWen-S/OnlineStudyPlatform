<template>
  <div>
    <h1>Admin Class Management</h1>
    <!-- 显示班级列表 -->
    <ul>
      <li v-for="classItem in classList" :key="classItem.id">
        {{ classItem.name }} - {{ classItem.description }}
        <button @click="editClass(classItem)">Edit</button>
        <button @click="deleteClass(classItem.id)">Delete</button>
      </li>
    </ul>
    <!-- 创建新班级的表单 -->
    <form @submit.prevent="createClass">
      <input type="text" v-model="newClass.name" placeholder="Name">
      <input type="text" v-model="newClass.description" placeholder="Description">
      <button type="submit">Create Class</button>
    </form>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      classList: [],
      newClass: { name: '', description: '' }
    };
  },
  methods: {
    fetchClassList() {
      axios.get('/api/classes/list') // 发送 GET 请求获取班级列表
          .then(response => {
            this.classList = response.data;
          })
          .catch(error => {
            console.error('Error fetching class list: ', error);
          });
    },
    createClass() {
      axios.post('/api/classes/create', this.newClass) // 发送 POST 请求创建新班级
          .then(response => {
            this.fetchClassList(); // 成功后刷新班级列表
            this.newClass = { name: '', description: '' }; // 清空表单
          })
          .catch(error => {
            console.error('Error creating class: ', error);
          });
    },
    editClass(classItem) {
      // 编辑班级的逻辑，发送 PUT 请求到 '/api/classes/edit/:id'
      // 通过后端编辑班级数据
    },
    deleteClass(classId) {
      axios.delete(`/api/classes/delete/${classId}`) // 发送 DELETE 请求删除班级
          .then(() => {
            this.fetchClassList(); // 成功后刷新班级列表
          })
          .catch(error => {
            console.error('Error deleting class: ', error);
          });
    }
  },
  created() {
    this.fetchClassList(); // 初始化时获取班级列表
  }
};
</script>

<style>
@import 'assets/css/styles.css';
</style>
