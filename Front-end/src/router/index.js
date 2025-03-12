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
      path:'/:id',name:'RobotShow',
      component:()=>import('../views/RobotShow.vue')
    },
    {
      path: '/team',
      name: 'team',
      component: () => import('../views/TeamView.vue'),
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
  ],
})

export default router
