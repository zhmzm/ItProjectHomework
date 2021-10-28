import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'

const routes = [
  {
    path: '/Shop',
    name: 'Shop',
    component: () => import('../views/Shop.vue')
  },
  {
    path: '/shop',
    name: 'Shop',
    component: () => import('../views/Shop'),
  },
  {
    path: '/shop/detail',
    name: 'Detail',
    component: () => import('../views/Detail'),
  },
  {
    path: '/shoppingcart',
    name: 'ShoppingCart',
    component: () => import('../views/ShoppingCart'),
  },
  {
    path: '/administrator',
    name: 'Administrator',
    component: () => import('../views/Administrator'),
    children: [
      {
        path: 'add',
        name: 'Add',
        component: () => import('../components/Add'),
      },
      {
        path: 'delete',
        name: 'Delete',
        component: () => import('../components/Delete'),
      },
      {
        path: 'permissions',
        name: 'Permissions',
        component: () => import('../components/Permissions'),
      },
    ]
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
