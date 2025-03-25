<template>
  <!-- 신청서 목록을 출력해주는 컴포넌트 -->
  <div class="home">
    <ul>
      <!-- state.forms 배열의 각 항목을 반복하여 출력 -->
      <li v-for="f in state.forms" :key="f.id">
        <div class="title">{{ f.title }}</div>
        <div class="desc">{{ f.description }}</div>
        <div class="date">{{ f.createdate }}</div>
      </li>
    </ul>
  </div>
</template>

<script setup>
import { reactive, onMounted } from 'vue';
import formServices from '@/services/formServices';

const state = reactive({
  forms: []
});

// 비동기 데이터 불러오기
const fetchForms = async () => {
  state.forms = await formServices.readAll();
  // 각 form 객체의 title을 출력
  state.forms.forEach(f => {
    console.log(f.title);
  });
};

onMounted(() => {
  fetchForms(); // 컴포넌트가 마운트되면 데이터 불러오기
});
</script>
