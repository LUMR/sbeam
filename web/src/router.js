import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'
import Banner from '@/components/Banner'

Vue.use(Router)

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      props: {
        session: {
          user: 'lumr'
        }
      },
      components: {
        default: Home,
        a: Banner
      }
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (about.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import(/* webpackChunkName: "about" */ './views/About.vue')
    },
    {
      path: '/demo',
      name: 'demo',
      component: () => import('@/views/Demo.vue')
    },
    {
      path: '/admin',
      name: 'admin',
      component: () => import('@/views/admin'),
      children: [{
        path: 'console',
        name: 'console',
        component: () => import('@/views/admin/console.vue')
      }]
    }
  ]
})
