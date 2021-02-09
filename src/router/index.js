import Vue from 'vue'
import VueRouter from 'vue-router'
import Draw from '../components/Draw.vue'
import DE from '../components/DrawEl'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    component: DE
  },

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
