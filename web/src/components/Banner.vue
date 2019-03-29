<template>
  <div class="banner">
    <div class="container">
      <div class="headr-right">
        <div class="details">
          <ul v-if="session.user != undefined">
            <li>
              <a href="/user/details">
                {{ '你好，' + session.user.name + session.user.city }}
                <span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>
              </a>
            </li>
            <li>
              <a href="/user/logout">
                <span class="glyphicon glyphicon-earphone" aria-hidden="true"></span>注销
              </a>
            </li>
          </ul>
          <ul v-if="session.user == undefined">
            <li>
              <a href="/user/login">
                <span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>登陆
              </a>
            </li>
            <li>
              <a href="/user/register">
                <span class="glyphicon glyphicon-earphone" aria-hidden="true"></span>注册
              </a>
            </li>
          </ul>
        </div>
      </div>
      <div class="banner_head_top">
        <div class="logo">
          <h1>
            <a href="/">
              Game
              <span class="glyphicon glyphicon-knight" aria-hidden="true"></span>
              <span>SBEAM</span>
            </a>
          </h1>
        </div>
        <div class="top-menu">
          <div class="content white">
            <nav class="navbar navbar-default">
              <div class="navbar-header">
                <button
                  type="button"
                  class="navbar-toggle"
                  data-toggle="collapse"
                  data-target="#bs-example-navbar-collapse-1"
                >
                  <span class="sr-only">Toggle navigation</span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                </button>
              </div>
              <!--/navbar header-->
              <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                  <li><router-link to="/">首页</router-link></li>
                  <li><router-link to="/library/">游戏商城</router-link></li>
                  <li><router-link to="/user/library">我的游戏库</router-link></li>
                  <li><router-link to="/user/details">我的信息</router-link></li>
                  <li><router-link to="/user/recharge">充值</router-link></li>
                  <li><router-link to="/demo">游戏信息查询</router-link></li>
                  <li><router-link to="/admin/console">控制台</router-link></li>
                </ul>
              </div>
              <!--/navbar collapse-->
            </nav>
            <!--/navbar-->
          </div>
          <div class="clearfix"></div>
        </div>
        <div class="clearfix"></div>
      </div>
      <div class="banner-info">
        <h3>欢迎来到Sbeam游戏商城</h3>
        <h2>Make By LUMR</h2>
      </div>
    </div>
  </div>
</template>

<script>
import '@/assets/css/bootstrap.css'
import '@/assets/css/style.css'

export default {
  props: ['session']
}
</script>
