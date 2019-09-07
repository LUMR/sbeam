<template>
  <div id="sideMenu">
    <el-radio-group v-model="isCollapse" style="margin-bottom: 20px;">
      <el-radio-button :label="false">展开</el-radio-button>
      <el-radio-button :label="true">收起</el-radio-button>
    </el-radio-group>
    <el-menu
      default-active="2"
      class="el-menu-vertical-demo"
      background-color="#746254"
      text-color="#fff"
      active-text-color="#ffd04b"
      @open="handleOpen"
      @close="handleClose"
      @select="handleSelect"
      :collapse="isCollapse"
    >
      <el-submenu v-for="(menu,nom) in menuSetting" :key="nom" :index="menu.path">
        <template slot="title">
          <i :class="menu.icon"></i>
          <span slot="title">{{ menu.name }}</span>
        </template>
        <el-menu-item-group>
          <el-menu-item v-for="(smenu,snom) in menu.son" :key="snom" :index="smenu.path">{{ smenu.name }}</el-menu-item>
        </el-menu-item-group>
      </el-submenu>
      <!-- <el-submenu index="/user">
        <template slot="title">
          <i class="el-icon-user"></i>
          <span>用户管理</span>
        </template>
        <el-menu-item-group>
          <el-menu-item index="/premission">用户权限</el-menu-item>
          <el-menu-item index="/role">用户角色</el-menu-item>
        </el-menu-item-group>
        <el-menu-item-group title="分组2">
          <el-menu-item index="1-3">选项3</el-menu-item>
        </el-menu-item-group>
        <el-submenu index="1-4">
          <template slot="title">选项4</template>
          <el-menu-item index="1-4-1">选项1</el-menu-item>
        </el-submenu>
      </el-submenu>
      <el-menu-item index="/game">
        <i class="el-icon-goods"></i>
        <span slot="title">游戏管理</span>
      </el-menu-item>
      <el-menu-item index="/3" disabled>
        <i class="el-icon-document"></i>
        <span slot="title">导航三</span>
      </el-menu-item>
      <el-menu-item index="/system">
        <i class="el-icon-setting"></i>
        <span slot="title">系统配置</span>
      </el-menu-item>-->
    </el-menu>

  </div>
</template>

<script>
export default {
  data () {
    return {
      isCollapse: false,
      menuSetting: [
        {
          path: '/user',
          name: '用户管理',
          icon: 'el-icon-user',
          son: [
            {
              path: '/permission',
              name: '权限管理',
              icon: ''
            },
            {
              path: '/role',
              name: '角色管理',
              icon: ''
            }
          ]
        },
        {
          path: '/game',
          name: '游戏管理',
          icon: 'el-icon-goods',
          son: [
            {
              path: '/permission',
              name: '权限管理'
            },
            {
              path: '/role',
              name: '角色管理'
            }
          ]
        },
        {
          path: '/system',
          name: '系统管理',
          icon: 'el-icon-setting',
          son: [
            {
              path: '/permission',
              name: '权限管理'
            },
            {
              path: '/role',
              name: '角色管理'
            }
          ]
        }
      ]
    }
  },
  methods: {
    handleOpen (key, keyPath) {
      this.$message(
        {
          message: key + '' + keyPath,
          type: 'success',
          showClose: true
        }
      )
    },
    handleClose (key, keyPath) {
      this.$message(
        {
          message: key + '' + keyPath,
          type: 'success',
          showClose: true
        }
      )
    },
    handleSelect (keyPath, key) {
      this.$message(
        {
          message: keyPath + '' + key,
          type: 'success',
          showClose: true
        }
      )
    }
  }
}
</script>

<style lang="scss">
.el-menu-vertical-demo:not(.el-menu--collapse) {
    width: 200px;
    min-height: 400px;
  }
</style>
