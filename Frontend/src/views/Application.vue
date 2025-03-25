<template>
  <!-- 신청서를 위한 뷰페이지:전체 리스트에서 특정리스트를 선택하면 세부 신청페이지가 나오는 역할 -->
    <div class="top">
        <div class="title" style="font-size: 24px; font-weight: bold;">제목: {{ state.form.title }}</div>
        <div class="desc" style="color:orange" > {{ state.form.description }}</div>

    </div>

  <form @submit="submit">
    <div class="mb-4">
      <label for="writerName" class="form-label">작성자명 </label>
      <input type="text" class="form-control" id="writerName" v-model="state.inputs.writerName" />
    </div>

    <div class="mb-4">
      <label for="ageRange" class="form-label">작성자명 </label>
      <select class="form-select" id="ageRange" aria-label="연령대" v-model="state.inputs.ageRange" >
        <option :value="10">10대</option>           <!-- :value   =>숫자형을 입력할 때 사용 -->
        <option :value="20">20대</option>
        <option :value="30">30대</option>
        <option :value="40">40대</option>
        <option :value="50">50대</option>
        <option :value="60">60대</option>
        <option :value="70">70대</option>
        <option :value="80">80대</option>
      </select>
    </div>

    <div class="mb-4">
        <label class="form-label">성별</label>
            <div>
                <div class="form-check form-check-inline">   <!-- form-check-inline: 가로로 나열 -->
                    <label class="form-check-label" for="genderMale"> 남자 </label>
                    <input  class="form-check-input" type="radio" id="genderMale" name="gender" v-model="state.inputs.gender" value="M"/>
                </div>

                <div class="form-check form-check-inline">
                    <label class="form-check-label" for="genderFemale"> 여자</label>
                    <input class="form-check-input" type="radio" id="genderFemale" name="gender" v-model="state.inputs.gender" value="F" />     
                    <!-- input에 name을 같게 하면 같은 그룹으로 묶이게 된다.:이걸 설정않하게 되면 둘다 선택이 된다. -->
                </div>
             </div>
    </div>

    <div class="mb-4">
        <label class="form-label">내용</label>
        <textarea class="form-control" v-model="state.inputs.content"></textarea>
    </div>

  </form>
</template>
<script setup>
import { reactive } from "vue";
import { useRoute } from "vue-router";
import formService from "@/services/formService";

const state = reactive({
    form:{            //신청서에 관한것들을 저장하는 객체
        id:0,
        title:"",
        description:"",
        createDate:"",
    },

    inputs:{       //입력에 관한것들을 저장하는 객체
    writerName: "", 
    ageRange: 10,
    gender:"M",
    content: "", 
    }
});

const submit = (event) => {
  window.alert("신청서가 제출되었습니다.");
};

const route=useRoute();   // 현재 URL 정보를 가져옴
const formId=route.params.id;  // URL의 "id" 파라미터 값을 가져옴

(async()=>{    //이 컴포넌트가 로드될 때 무조건 실행되는 비동기 함수
    state.form=await formService.read(formId);
    console.log(form.title, ":불러오기 완료");
})();
</script>

<style lang="scss" scoped></style>
