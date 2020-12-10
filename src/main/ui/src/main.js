import Vue from 'vue'
import App from './App.vue'
import { BootstrapVue } from 'bootstrap-vue'
import router from './router'

import "bootstrap/dist/css/bootstrap.min.css"
import "bootstrap-vue/dist/bootstrap-vue.css"


new Vue({
  router,
  el: '#app',
  render: h => h(App)
})

Vue.use(BootstrapVue);
