<template>
  <div id="app">
    <el-container>
      <el-header height="500px">
        <Banner v-bind:session="session" />
      </el-header>
      <el-container>
        <el-aside id="side-menu">
          <SideMenu />
        </el-aside>
        <el-container >
          <el-main id="main-view"><router-view /></el-main>
          <el-footer>Footer</el-footer>
        </el-container>
      </el-container>
    </el-container>
  </div>
</template>

<style lang="scss">
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
#side-menu {
  padding-left: 20px
}
#main-view {
  padding: 0 0 0 0
}

#i-nav {
  padding: 30px;
  a {
    font-weight: bold;
    color: #2c3e50;
    &.router-link-exact-active {
      color: #42b983;
    }
  }
}
</style>

<script>
import Banner from '@/components/Banner'
import SideMenu from '@/components/SideMenu'

export default {
  components: { Banner, SideMenu },
  data () {
    return {
      session: {
        user: {
          name: 'lumr',
          city: '佛山'
        }
      }
    }
  }
}
</script>
