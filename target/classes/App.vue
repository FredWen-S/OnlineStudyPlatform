<template>
  <div id="app">
    <!-- 导航栏组件 -->
    <router-link to="/">Home</router-link>
    <router-link to="/dashboard">Dashboard</router-link>

    <!-- 路由出口 -->
    <router-view />
  </div>
</template>

<script>
export default {
  name: 'App',
  // 添加路由配置
  // 导入的路由文件应该在这里配置
};
</script>

<style>
/* 全局样式可以放在这里 */
body {
  font-family: Arial, sans-serif;
  margin: 0;
  padding: 0;
}
</style>
