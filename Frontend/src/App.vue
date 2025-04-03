<template>   
  <!-- App.vue는 Vue 애플리케이션의 기본 페이지 구조를 담당하며, index.html의 <div id="app"></div>에 렌더링됨 -->
  <!-- <header>와 <footer>는 고정된 부분이며, <router-view>를 통해 페이지의 주요 내용이 동적으로 변경됨 -->
  <header>
    <div class="container">
      <center><h1> <router-link to="/">신청서 애플리케이션 </router-link> </h1>  </center>   
      <!-- <router-link to="/">: 클릭하면 '/' 경로로 이동 (Home 페이지로 이동) -->
      <!-- Vue에서는 <router-link>가 실제로 <a> 태그로 변환됨 -->
    </div>
  </header>     

  <main>   
    <!-- <main>: 웹 페이지의 주요 콘텐츠를 담는 영역 -->
    <div class="container">
        <router-view></router-view>   
<!-- ***✅ <router-view> → 컴포넌트를 보여줄 위치 지정 & 기본적으로 index.js에서 '/' 경로의 컴포넌트를 렌더링, 일반적으로 이 태그를 하나만 사용, 나중에 여러개 사용법을 배우자
     ***✅ <router-link> → index.js에서 설정한 path를 찾아 이동하고 <router-view>에 컴포넌트를 랜더링 -->
    </div>
  </main>

  <footer>
    <div class="container">  &copy; 2025. Example. All Rights Reserved. </div>
  </footer>
</template>

<script setup>
//Composition API의 setup()을 사용하는 Vue 3의 기본 구조 
</script>

<style lang="scss" scoped>
  header {
    padding: 30px 0;
    border-bottom: 1px solid #f87d7d;
    margin-bottom: 30px;
    
    h1 {
      font-size: 20px;
      font-weight: 500;
      
      a {  // Vue에서 <router-link>가 실제 HTML에서는 <a> 태그로 변환됨
        text-decoration: none;  // 밑줄 제거
        color: inherit;  // 부모 요소의 색상을 상속받음
      }
    }
  }

  footer {
    padding: 30px 0;
    margin-top: 30px;
    border-top: 1px solid #ddd;
  } 
</style>
