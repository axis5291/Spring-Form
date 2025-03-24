<script setup>

</script>

<template>
  <header>
    <div class="container">
        <h1> 신청서 애플리케이션  </h1>
    </div>
  </header>     
  <main>
    <div class="container">
        <router-view></router-view>   <!-- index,js에 경로가 설정되어 있다. -->
        
    </div>
  </main>

  <footer>
    <div class="container">
      &copy; 2025. Example. All Rights Reserved.
    </div>
  </footer>
</template>