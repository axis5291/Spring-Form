<template>    <!-- 신청서 목록을 출력하는 컴포넌트 -->
  <div class="home">
    <ul>
      <li v-for="f in state.forms" :key="f.id">    <!-- state.forms 배열의 각 항목을 반복하여 출력 -->
        <router-link :to="`/forms/${f.id}`">       <!--index.js에서 설정한 /forms/id는 Applicatio.vue로 연결된다. *** 아래 주석 참조   -->
            <center> <div class="title">{{ f.title }}</div></center>
            <div class="desc">{{ f.description }}</div>
            <div class="date">생성일시:{{ f.createDate }}</div>
        </router-link>
      </li>
    </ul>
  </div>
   <!-- *** router-link를 쓰려면 index.js에서 정의한 path부분와 일치시킨다.
            뷰 템플릿에서는 동적변수를 넘길때는 백틱(``)안에 ${}표현으로 넘기고 index.js의 라우터에서는 :id 식으로 넘긴다. -->
</template>

<script setup>
import { reactive, onMounted } from "vue";
import formService from "@/services/formService"; // Axios를 이용하여 데이터를 불러오는 formService.js 파일, @는 jsconfig.json에서 설정한 alias 경로

const state = reactive({
  forms: [], // 신청서 목록을 저장하는 배열
});

// **서버에서 데이터를 가져오는 비동기 함수**
const fetchForms = async () => {
  try {
    state.forms = await formService.readAll(); // 백엔드 API에서 신청서 목록 불러와서 배열(state.forms)에 담음

    state.forms.forEach((f) => {   //state.forms은 배열인데 배열을 그대로 출력하면 Object이 출력됨, 그래서 배열의 요소인 객체를 하나 꺼내서 출력한다. f는 배열의 한 요소인 객체
      console.log(f.title); // 각 form 객체의 title을 출력 (디버깅용),  console.log(f)하면 객체 전체가 출력됨
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
  fetchForms();    //함수 실행은 이와 같이 한다.
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
          font-color: rgb(244, 150, 7);
        }

        &:hover {
          background: #f7f7f7;
        }
      }
    }
  }
}
</style>
