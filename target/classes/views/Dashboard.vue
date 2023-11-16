<template>
  <div class="dashboard">
    <h2>Dashboard</h2>
    <div v-if="isLoggedIn">
      <!-- 根据用户权限和角色显示不同的内容 -->
      <h3 v-if="isTeacher">Teacher Dashboard</h3>
      <h3 v-else-if="isAdmin">Admin Dashboard</h3>
      <h3 v-else>Student Dashboard</h3>

      <!-- 根据角色显示不同的功能模块 -->
      <div v-if="isTeacher">
        <!-- 教师特有的功能 -->
        <ManageClass />
        <UploadMaterial />
        <!-- 其他教师功能 -->
      </div>
      <div v-else-if="isAdmin">
        <!-- 管理员特有的功能 -->
        <!-- 管理用户、材料等 -->
      </div>
      <div v-else>
        <!-- 学生特有的功能 -->
        <MaterialList />
        <ClassList />
        <!-- 其他学生功能 -->
      </div>
    </div>
    <div v-else>
      <p>Please log in to access the dashboard.</p>
      <!-- 登录组件或登录链接 -->
      <Login />
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';
import MaterialList from '@/components/Materials/MaterialList.vue';
import UploadMaterial from '@/components/Materials/UploadMaterial.vue';
import ClassList from '@/components/Classes/ClassList.vue';
import ManageClass from '@/components/Classes/ManageClass.vue';
import Login from '@/components/Auth/Login.vue';

export default {
  components: {
    MaterialList,
    UploadMaterial,
    ClassList,
    ManageClass,
    Login
  },
  computed: {
    ...mapGetters([
      'isLoggedIn',
      'getUserData'
      // 根据需要获取其他 getter 方法
    ]),
    isTeacher() {
      // 根据用户角色判断是否是教师
      return this.getUserData && this.getUserData.role === 'teacher';
    },
    isAdmin() {
      // 根据用户角色判断是否是管理员
      return this.getUserData && this.getUserData.role === 'admin';
    }
  }
  // 可以添加其他逻辑和生命周期钩子
};
</script>

<style>
/* 根据需要添加样式 */
.dashboard {
  /* 你的样式 */
}
</style>
