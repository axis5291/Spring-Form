<template>
  <!-- 신청서 목록을 출력하는 컴포넌트 -->
  <div class="home">
    <ul>
      <!-- state.forms 배열의 각 항목을 반복하여 출력 -->
      <li v-for="f in state.forms" :key="f.id">
        <router-link :to="`/forms/${f.id}`">       <!-- 아래 3개중에 아무거나 클릭하면 해당 신청서로 이동합니다. -->
          <div class="title">{{ f.title }}</div>
          <div class="desc">{{ f.description }}</div>
          <div class="date">생성일시:{{ f.createDate }}</div>
        </router-link>
      </li>
    </ul>
  </div>
</template>

<script setup>
import { reactive, onMounted } from "vue";
import formService from "@/services/formService"; // Axios를 이용하여 데이터를 불러오는 formService.js 파일

const state = reactive({
  forms: [], // 신청서 목록을 저장하는 배열
});

// **서버에서 데이터를 가져오는 비동기 함수**
const fetchForms = async () => {
  try {
    state.forms = await formService.readAll(); // 백엔드 API에서 신청서 목록 불러오기

    state.forms.forEach((f) => {
      console.log(f.title); // 각 form 객체의 title을 출력 (디버깅용)
    });
  } catch (error) {
    console.error("데이터 요청 실패:", error);
  }
};

// `.then()`을 사용하는 비동기 처리 방식 (대체 가능)
// const fetchForms = () => {
//   formService.readAll()
//     .then(response => {
//       state.forms = response; // 데이터를 상태(state)에 저장
//       console.log("데이터 요청 완료");
//     })
//     .catch(error => {
//       console.error("데이터 요청 실패:", error);
//     });
// };

// **컴포넌트가 마운트될 때 데이터 로딩**
onMounted(() => {
  fetchForms();
});
</script>

<style lang="scss" scoped>
.home {
  ul {
    list-style: none;
    margin: 0;
    padding: 0;

    li {
      margin: 0;
      padding: 0;
      border: 1px solid #ddd;

      a {
        display: block;
        padding: 15px;
        text-decoration: none;
        color: inherit;

        .title {
          font-weight: bold;
        }

        &:hover {
          background: #f7f7f7;
        }
      }
    }
  }
}
</style>
