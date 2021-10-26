import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'

const routes = [
  {
    path: '/Shop',
    name: 'Shop',
    component: () => import('../views/Shop.vue')
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  },
  {
    path: '/loginandregister',
    name: 'LoginAndRegister',
    component: () => import('../views/LoginAndRegister'),
    children: [
      {
        path: 'login',
        name: 'Login',
        component: () => import('../components/Login'),
      },
      {
        path: 'register',
        name: 'Register',
        component: () => import('../components/Register'),
      }
    ]
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
