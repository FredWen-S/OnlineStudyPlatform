<template>
  <div class="home">
    <h2>Welcome to Online Education Platform</h2>
    <div>
      <!-- 可以根据需要添加内容 -->
      <p>Explore our materials:</p>
      <MaterialList />
    </div>
    <div>
      <!-- 其他内容，例如课程列表等 -->
      <ClassList />
    </div>
  </div>
</template>

<script>
import MaterialList from '@/components/Materials/MaterialList.vue';
import ClassList from '@/components/Classes/ClassList.vue';

export default {
  components: {
    MaterialList,
    ClassList
    // 如果有其他组件，也可以在此处引入
  }
  // 可以添加其他逻辑和生命周期钩子
};
</script>

<style>

.home {
@import '../../assets/css/styles.css';
}
</style>
