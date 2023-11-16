<template>
  <div class="register">
    <h2>注册</h2>
    <form @submit.prevent="register">
      <div class="form-group">
        <label for="username">用户名</label>
        <input type="text" id="username" v-model="username" required>
      </div>
      <div class="form-group">
        <label for="email">邮箱</label>
        <input type="email" id="email" v-model="email" required>
      </div>
      <!-- 角色选择 -->
      <div class="form-group">
        <label for="role">角色</label>
        <select id="role" v-model="selectedRole" @change="onRoleChange">
          <option value="student">学生</option>
          <option value="teacher">老师</option>
        </select>
      </div>
      <!-- 老师特有字段 -->
      <div v-if="selectedRole === 'teacher'">
        <div class="form-group">
          <label for="department">学院/办公室</label>
          <input type="text" id="department" v-model="department" required>
        </div>
        <!-- ... 其他老师特有字段 -->
      </div>
      <!-- 学生特有字段 -->
      <div v-if="selectedRole === 'student'">
        <div class="form-group">
          <label for="major">专业</label>
          <input type="text" id="major" v-model="major" required>
        </div>
        <!-- ... 其他学生特有字段 -->
      </div>
      <button type="submit">注册</button>
    </form>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      username: '',
      email: '',
      selectedRole: 'student', // 默认角色选择
      department: '', // 老师所属学院/办公室
      major: '' // 学生所属专业
      // 其他与角色相关的字段可以在这里添加
    };
  },
  methods: {
    register() {
      const userData = {
        username: this.username,
        email: this.email,
        role: this.selectedRole,
        // 根据选择的角色包含其他字段
        ...(this.selectedRole === 'teacher' && { department: this.department }),
        ...(this.selectedRole === 'student' && { major: this.major })
      };

      axios.post('/api/register', userData)
          .then(response => {
            console.log('注册成功', response.data);
            // 处理成功 - 跳转或显示成功信息
          })
          .catch(error => {
            console.error('注册失败', error.response.data);
            // 处理失败 - 显示错误信息
          });
    },
    onRoleChange() {
      // 角色变化时重置特定字段
      this.department = '';
      this.major = '';
    }
  }
};
</script>

<style>
/* 引入外部样式文件 */
@import 'assets/css/styles.css';

</style>
