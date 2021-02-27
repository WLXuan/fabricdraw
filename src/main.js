import '@babel/polyfill'
import 'mutationobserver-shim'
import Vue from 'vue'
import './plugins/bootstrap-vue'
import './plugins/bootstrap-vue'
import App from './App.vue'
import router from './router'
import store from './store'
import BootstrapVue from 'bootstrap-vue'
import fabric from 'fabric'

Vue.use(fabric)

import axios from 'axios'
// axios.defaults.baseURL = 'http://localhost:8080'
// axios.defaults.headers.post['Content-Type'] = 'application/json'
Vue.prototype.$axios = axios.create({
  baseURL: 'http://localhost:8080',
  headers: {
    'Content-Type': 'application/json'
  }
})

import VueAxios from 'vue-axios'
Vue.use(VueAxios)

import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import './plugins/element.js'

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
