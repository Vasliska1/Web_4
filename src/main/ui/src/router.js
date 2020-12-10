import Vue from 'vue'
import Router from 'vue-router'

import Register from "./register/MainRegister.vue";
import Main from "./mainScreen/Main.vue"
Vue.use(Router)
export default new Router({
        mode: 'history',
        routes:[
            {
                path:'/',
                component: Register
            },
            {
                path:'/main',
                component: Main
            }
        ]
    }
)