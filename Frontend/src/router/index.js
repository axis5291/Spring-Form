import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',       //사용자가 이경로로 들어오게 되면
      name: 'home',    //home컴포넌트가 사용되어진다.
      component: import('../views/Home.vue'), //home 컴포넌트가 위치한 곳
    },
    {
      path: '/forms/:id',       //:id는 동적으로 변하는 값이다.
      name: 'application',    
      component: import('../views/Application.vue'), 
    },
  ]
})

export default router
