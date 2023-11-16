<template>
  <div class="material-list">
    <h2>Materials</h2>
    <ul>
      <li v-for="material in materials" :key="material.id">
        <h3>{{ material.title }}</h3>
        <p>Description: {{ material.description }}</p>
        <p>Uploaded by: {{ material.uploadedBy }}</p>
        <!-- Other material details to display -->
      </li>
    </ul>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      materials: [] // 初始化为空数组
    };
  },
  mounted() {
    this.fetchMaterials(); // 在组件加载时调用获取数据的方法
  },
  methods: {
    fetchMaterials() {
      axios.get('/api/materials/list') // 发送 GET 请求到后端 API
          .then(response => {
            this.materials = response.data; // 将后端返回的数据赋值给 materials 属性
          })
          .catch(error => {
            console.error('Error fetching materials', error);
          });
    }
  }
};
</script>

<style>
/* Add styles specific to MaterialList.vue component */
@import '../../assets/css/styles.css';
.material-list {
  /* Your styles here */
}
</style>
