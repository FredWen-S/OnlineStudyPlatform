<template>
  <div class="upload-material">
    <h2>Upload Material</h2>
    <form @submit.prevent="uploadFile">
      <div class="form-group">
        <label for="title">Title</label>
        <input type="text" id="title" v-model="title" required>
      </div>
      <div class="form-group">
        <label for="description">Description</label>
        <textarea id="description" v-model="description"></textarea>
      </div>
      <div class="form-group">
        <label for="file">File</label>
        <input type="file" id="file" @change="handleFileChange" required>
      </div>
      <button type="submit">Upload</button>
    </form>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      title: '',
      description: '',
      file: null
    };
  },
  methods: {
    handleFileChange(event) {
      this.file = event.target.files[0]; // 获取上传的文件
    },
    uploadFile() {
      const formData = new FormData(); // 创建一个 FormData 对象来传输文件和其他数据
      formData.append('title', this.title);
      formData.append('description', this.description);
      formData.append('file', this.file);

      axios.post('/api/upload', formData, {
        headers: {
          'Content-Type': 'multipart/form-data' // 设置请求头，表明传输的是文件数据
        }
      })
          .then(response => {
            console.log('File uploaded successfully', response.data);
            // 处理上传成功的逻辑
          })
          .catch(error => {
            console.error('File upload failed', error);
            // 处理上传失败的逻辑
          });
    }
  }
};
</script>

<style>
@import '../../assets/css/styles.css';
.upload-material {
  /* Your styles here */
}
</style>
