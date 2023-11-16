<template>
  <div>
    <h1>Admin Material Management</h1>
    <!-- 显示教学材料列表 -->
    <ul>
      <li v-for="material in materialList" :key="material.id">
        {{ material.name }} - {{ material.type }}
        <button @click="editMaterial(material)">Edit</button>
        <button @click="deleteMaterial(material.id)">Delete</button>
      </li>
    </ul>
    <!-- 上传教学材料的表单 -->
    <form @submit.prevent="uploadMaterial">
      <input type="text" v-model="newMaterial.name" placeholder="Name">
      <input type="text" v-model="newMaterial.type" placeholder="Type">
      <button type="submit">Upload Material</button>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      materialList: [], // 存储教学材料列表
      newMaterial: { name: '', type: '' } // 新教学材料数据
    };
  },
  methods: {
    // 获取教学材料列表的方法（可能需要从后端获取）
    fetchMaterialList() {
      // 使用 Axios 或其他库从后端获取教学材料列表
      // 更新 this.materialList
    },
    // 上传新教学材料的方法
    uploadMaterial() {
      // 使用 Axios 或其他库向后端上传新教学材料
      // 成功后更新 this.materialList
      this.newMaterial = { name: '', type: '' }; // 清空表单
    },
    // 编辑教学材料的方法
    editMaterial(material) {
      // 编辑教学材料的逻辑
    },
    // 删除教学材料的方法
    deleteMaterial(materialId) {
      // 删除教学材料的逻辑
    }
  },
  created() {
    this.fetchMaterialList(); // 初始化时获取教学材料列表
  }
};
</script>

<style>
/* 样式 */
</style>
