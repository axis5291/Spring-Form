<script setup>

</script>

<template>
  <header>
    <div class="container">
      <router-link to="/"><h1> 신청서 애플리케이션  </h1></router-link>    <!-- <router-link to="/">:여기를 클릭하면 /으로 이동합니다. -->
     </div>
  </header>     
  <main>                              <!-- main태그:웹 페이지의 주요 콘텐츠를 담는 역할,   body태그:모든 콘텐츠를 읽음-->
    <div class="container">
        <router-view></router-view>   <!-- index,js에 경로가 설정되어 있다.<router-view>는 내용이 동적으로 바꾸어주는 역할을 한다. -->
        
    </div>
  </main>

  <footer>
    <div class="container">
      &copy; 2025. Example. All Rights Reserved.
    </div>
  </footer>
</template>

<style lang="scss" scoped>
  header{
    padding: 30px 0;
    border-bottom: 1px solid #ddd;
    margin-bottom: 30px;
    h1{
      font-size: 20px;
      font-weight: 500px;
      a{
        text-decoration: none;
        color: inherit;
       
      }
    }
  }

  footer{
    padding: 30px 0;
    margin-top: 30px;
    border-top: 1px solid #ddd;
  }

 
</style>