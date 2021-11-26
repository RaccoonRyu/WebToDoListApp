import Vue from 'vue' // 1. Vue를 사용 할 수 있도록 import한다.
import Router from 'vue-router' // 2. Router를 사용 할 수 있도록 import한다.
import Hello from '@/components/Hello' // 3. 경로 설정을 원하는 컴포넌트를 import 한다.
import About from '@/components/About' // component를 import한다 .vue는 안 써줘도 됨.

Vue.use(Router) // 4. Vue에게 Router를 사용하라고 알려준다.

// 5. 실제 경로 설정
export default new Router({
  routes: [
    {
      path: '/', // http://localhost:8080/으로 누가 들어오면
      name: 'Hello', // 이 경로에 Hello라는 이름을 붙이고
      component: Hello // <router-view></router-view>에 Hello.vue 컴포넌트를 이어준다.
    },
    {
      path: '/about', // http://localhost:8080/about 경로에 맵핑 해 준다.
      name: 'About',
      component: About // About.vue를 맵핑 해 준다.
    }
  ]
})
