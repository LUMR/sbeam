<template>
  <div>
    <h1>{{ message }}</h1>
    <p>hello!<span>{{ time }}</span> </p>
    <a href="/">回首页</a>
  </div>
</template>

<script>
export default {
  data () {
    return {
      message: 'what is This?',
      time: new Date().toLocaleTimeString()
    }
  }
}
</script>
