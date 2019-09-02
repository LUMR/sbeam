<template>
  <el-form ref="form" :model="form" label-width="120px">
    <el-form-item label="方法名称">
      <el-input v-model="form.name"></el-input>
    </el-form-item>
    <el-form-item>
      <el-input
        type="textarea"
        :rows="10"
        placeholder="请输入内容"
        v-model="form.textarea">
      </el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="onSubmit">执行</el-button>
      <el-button>取消</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
import instance from '@/api'

export default {
  data () {
    return {
      form: {
        name: '执行器',
        textarea: ''
      }
    }
  },
  methods: {
    onSubmit () {
      let { name, textarea: javaStr } = this.$data.form
      instance.post('/health/java/execute', {
        name, javaStr
      }).then(res => {
        this.$notify({
          title: '运行结果',
          message: res.data,
          duration: 0
        })
      }).catch(error => {
        let res = error.response
        this.$notify({
          title: '运行错误',
          message: res.data,
          duration: 0
        })
      })
    }
  }
}
</script>
