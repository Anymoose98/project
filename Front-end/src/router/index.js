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
      path:'/:id',name:'showRobot',
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
  ],
})

export default router
