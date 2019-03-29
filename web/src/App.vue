<template>
  <div id="app">
    <el-container>
      <el-header height="500px">
        <Banner v-bind:session="ps"/>
      </el-header>
      <el-container>
        <el-aside width="200px">
          <div id="i-nav">

          </div>
        </el-aside>
        <el-main><router-view/></el-main>
      </el-container>
    </el-container>
  </div>
</template>

<style lang="scss">
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
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

export default {
  components: { Banner },
  data () {
    return {
      ps: {
        user: {
          name: 'lumr',
          city: '佛山'
        }
      }
    }
  }
}
</script>
