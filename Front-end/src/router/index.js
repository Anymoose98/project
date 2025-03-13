import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView,
    },
    {
      path: '/robot',
      name: 'robot',
      component: () => import('../views/RobotView.vue'),
    },
    {
      path:'/robot/:id',name:'RobotShow',
      component:()=>import('../views/RobotShow.vue')
    },
    {
      path: '/robot/add',
      component: () => import('../views/RobotAdd.vue'),
    },
    {
      path: '/team',
      name: 'team',
      component: () => import('../views/TeamView.vue'),
    },
    {
      path:'/team/:id',name:'TeamShow',
      component:()=>import('../views/TeamShow.vue')
    },
    {
      path: '/team/add',
      component: () => import('../views/TeamAdd.vue'),
    },
    {
      path: '/tornei',
      name: 'tornei',
      component: () => import('../views/TorneiView.vue'),
    },
    {
      path:'/tornei/:id',name:'TorneoShow',
      component:()=>import('../views/TorneoShow.vue')
    },
    {
      path: '/tornei/add',
      component: () => import('../views/TorneiAdd.vue'),
    },
  ],
})

export default router
