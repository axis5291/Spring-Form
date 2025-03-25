import { fileURLToPath, URL } from 'node:url'

import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import vueDevTools from 'vite-plugin-vue-devtools'

// https://vite.dev/config/
export default defineConfig({
  server: {  //cors문제 해결을 위한 설정정보
    proxy: {
      '/v1/api': {                         //  /v1/api/로 들어오는 요청을 백엔드(http://backend-server:8080/)로 전달
        target: 'http://localhost:8080', // 백엔드 주소
      },
    },
  },  
  plugins: [
    vue(),
    vueDevTools(),
  ],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    },
  },
})
