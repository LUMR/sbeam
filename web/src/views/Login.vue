<template>
  <el-form ref="form1" :model="form" label-width="80px" width="500px">
    <el-form-item label="用户名">
      <el-input v-model="form.name"></el-input>
    </el-form-item>
    <el-form-item label="密码" prop="password">
      <el-input type="password" v-model="form.pass" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="submitForm('form1')">提交</el-button>
      <el-button @click="resetForm('form1')">重置</el-button>
  </el-form-item>
  </el-form>
</template>

<script>
import req from '@/api'

export default {
  data () {
    return {
      form: {
        name: '',
        pass: ''
      }
    }
  },
  methods: {
    submitForm (fromName) {
      let { name, pass } = this.$data.form
      let fd = new FormData()
      fd.append('name', name)
      fd.append('password', pass)
      req.post('/user/login', fd, { headers: { 'Content-Type': 'application/x-www-form-urlencoded' } })
        .then(res => {
          this.$message('登陆成功。')
        })
    }
  }
}
</script>
