<template>
  <!-- 신청서 목록을 출력해주는 컴포넌트 -->
  <div class="home">
    <ul>
      <!-- state.forms 배열의 각 항목을 반복하여 출력 -->
      <li v-for="f in state.forms" :key="f.id">
        <div class="title">{{ f.title }}</div>
        <div class="desc">{{ f.description }}</div>
        <div class="date">{{ f.createDate }}</div>
      </li>
    </ul>
  </div>
</template>

<script setup>
import { reactive, onMounted } from 'vue';
import formService from '@/services/formService';

const state = reactive({
  forms: []
});

// (async () => {     //강의코드드
//   state.forms = await formService.readAll();
// })();



const fetchForms = async () => {      // 비동기 데이터 불러오기(Ai 추천)
  state.forms = await formService.readAll();
  
  state.forms.forEach(f => {
    console.log(f.title);   // 각 form 객체의 title을 출력
  });
};

onMounted(() => {      // 컴포넌트가 마운트되면 데이터 불러오기
  fetchForms(); 
});


</script>
