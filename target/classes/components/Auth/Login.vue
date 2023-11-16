<<template>
  <div class="login">
    <h2>Login</h2>
    <form @submit.prevent="login">
      <div class="form-group">
        <label for="username">Username</label>
        <input type="text" id="username" v-model="username" required>
      </div>
      <div class="form-group">
        <label for="password">Password</label>
        <input type="password" id="password" v-model="password" required>
      </div>
      <button type="submit">Login</button>
    </form>
  </div>
</template>

<script>
// 导入 Axios
import axios from 'axios';

export default {
  data() {
    return {
      username: '',
      password: ''
    };
  },
  methods: {
    login() {
      // 创建一个对象，包含登录所需的凭据
      const credentials = {
        username: this.username,
        password: this.password
      };

      // 发送登录请求
      axios.post('/api/login', credentials)
          .then(response => {
            // 请求成功
            console.log('Login successful', response.data);
            // 这里可以进行成功登录后的操作，比如重定向到其他页面或者更新状态
          })
          .catch(error => {
            // 请求失败
            console.error('Login failed', error.response.data);
            // 这里可以处理登录失败的情况，比如显示错误信息
          });
    }
  }
};
</script>

<style>
/* 这里可以添加样式 */
.login {
  max-width: 300px;
  margin: auto;
}
.form-group {
  margin-bottom: 1rem;
}
label {
  display: block;
}
input {
  width: 100%;
  padding: 0.5rem;
  margin-top: 0.3rem;
}
button {
  padding: 0.5rem 1rem;
  background-color: #007bff;
  color: #fff;
  border: none;
  cursor: pointer;
}
button:hover {
  background-color: #0056b3;
}
</style>
