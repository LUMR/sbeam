<template>
  <div id="nav">
    <el-form :inline="true" :model="formInline" class="demo-form-inline">
      <el-form-item>
        <el-button type="primary" @click="dialogFormVisible = true">新增</el-button>
      </el-form-item>
      <el-form-item label="姓名">
        <el-input v-model="formInline.name" placeholder="姓名"></el-input>
      </el-form-item>
      <el-form-item label="系列">
        <el-select v-model="formInline.city" placeholder="系列">
          <el-option v-for="opt in formInline.options" v-bind:key="opt" v-bind:label="opt" v-bind:value="opt"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onQuery">查询</el-button>
      </el-form-item>
    </el-form>

    <el-table :data="tableData" border v-loading="loading" style="width: 100%" max-height="500">
      <el-table-column
        fixed
        prop="date"
        label="日期"
        width="150">
      </el-table-column>
      <el-table-column v-for="(col,index) in cloumnConfig"
        v-bind:prop="col.prop"
        v-bind:label="col.label"
        v-bind:width="col.width"
        v-bind:key="index">
      </el-table-column>
      <el-table-column
        fixed="right"
        label="操作"
        width="120">
        <template slot-scope="scope">
          <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
          <el-button @click="edit(scope.row)" type="text" size="small">编辑</el-button>
          <el-button @click="handleDelete(scope.row)" type="text" size="small">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-dialog title="新增信息" :visible.sync="dialogFormVisible" :show-close="false">
      <el-form :model="dialogform">
        <el-form-item label="姓名">
          <el-input v-model="dialogform.name" autocomplete="off" placeholder="请输入姓名"></el-input>
        </el-form-item>
        <el-form-item label="省份" >
          <el-select v-model="dialogform.p1" placeholder="请选择活动区域">
            <el-option v-for="opt in formInline.options" v-bind:key="opt" v-bind:label="opt" v-bind:value="opt"></el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="cancleEdit">取 消</el-button>
        <el-button type="primary" @click="comfirm">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import instance from '@/api'

export default {
  data () {
    return {
      dialogFormVisible: false,
      loading: true,
      dialogform: {},
      formInline: {
        name: undefined,
        city: undefined,
        options: []
      },
      tableData: [],
      cloumnConfig: [
        {
          prop: 'name',
          label: '姓名',
          width: '120'
        },
        {
          prop: 'province',
          label: '省份',
          width: '120'
        },
        {
          prop: 'city',
          label: '市区',
          width: '120'
        },
        {
          prop: 'p1',
          label: '平台',
          width: '120'
        },
        {
          prop: 'p2',
          label: '组织',
          width: '120'
        },
        {
          prop: 'province',
          label: '省份',
          width: '120'
        },
        {
          prop: 'city',
          label: '市区',
          width: '120'
        }
      ]
    }
  },
  created: function () {
    this.$data.loading = true
    instance.get('/game/list').then(res => {
      this.$data.tableData = new Array(res.data.size)
      this.$data.formInline.options = []
      let options = this.$data.formInline.options
      res.data.forEach((a, index) => {
        let { name, description: p1, pubdate: date } = a
        this.$data.tableData[index] = ({ name, p1, date })
        if (options.indexOf(p1) < 0) {
          options.push(p1)
        }
      })
    })
    this.$data.loading = false
  },
  methods: {
    onQuery () {
      this.$data.loading = true
      let { name, city: description } = this.$data.formInline
      instance.get('/game/list', {
        params: { name, description }
      }).then(response => {
        this.$data.tableData = new Array(response.data.size)
        response.data.forEach((a, index) => {
          let { name, description: p1, pubdate: date } = a
          this.$data.tableData[index] = ({ name, p1, date })
        })
      }).then(() => {
        this.$data.loading = false
      })
    },
    handleClick (row) {
      let str = JSON.stringify(row)
      this.$message({
        showClose: true,
        message: `你好，${str}!`,
        type: 'success'
      })
    },
    handleDelete (row) {
      let index = this.$data.tableData.indexOf(row)
      if (index !== -1) {
        this.$data.tableData.splice(index, 1)
      }
      this.$message({
        message: '删除成功',
        showClose: true,
        type: 'success'
      })
    },
    addData () {
      let newrow = { date: Date() }
      let data = this.$data
      Object.assign(newrow, data.dialogform)
      data.tableData.push(newrow)
      data.dialogFormVisible = false
      data.dialogform = {}
      this.$message({
        message: '新增成功。',
        type: 'success',
        showClose: true
      })
    },
    comfirm () {
      if (this.$data.dialogform.mode !== 'edit') {
        this.addData()
      } else {
        let { name, p1, row } = this.$data.dialogform
        Object.assign(row, { name, p1 })
        this.$data.dialogform = {}
        this.$data.dialogFormVisible = false
      }
    },
    cancleEdit () {
      let data = this.$data
      data.dialogform = {}
      data.dialogFormVisible = false
    },
    edit (row) {
      let data = this.$data
      let { name, p1 } = row
      data.dialogform = { name, p1, row, mode: 'edit' }
      data.dialogFormVisible = true
    }
  }
}
</script>
