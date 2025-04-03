<template>  <!-- 신청서를 위한 뷰페이지:전체 리스트에서 특정리스트를 선택하면 세부 신청페이지가 나오는 역할 -->
    <div class="application">
        <div class="top">
            <span class="title">제목: {{ state.form.title }}</span>
            <br>
            <span class="desc"> {{ state.form.description }}</span>
        </div>
    
      <form @submit.prevent="submit"> <!-- 제출버튼을 누르며 팝업창이 뜨는데 그 창의 확인을 누르면 미세하게 새로고침 현상이 나타나는데 새로고침 현상을 막기위해 .prevent가 사용됨 -->
          <div class="mb-4">
            <label for="writerName" class="form-label">작성자명 </label>
            <input type="text" class="form-control" id="writerName" v-model="state.inputs.writerName"/> <!-- *for="writerName" → label이 id="writerName"인 input과 연결됨, label을 클릭하면 자동으로 해당 input으로 포커스 이동-->
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
            <button type="submit" class="btn btn-primary w-100 p-3">제출</button>
      </form>
    </div>
</template>

<script setup>
import { reactive } from "vue";
import { useRoute, useRouter } from "vue-router";
import formService from "@/services/formService";
import applicationService from '@/services/applicationService';

const route = useRoute();   // 현재 URL 정보를 가져옴
const router = useRouter();  // 라우터 객체 추가

// useRouter() 추가: route.push("/")를 사용하려면 useRouter()를 통해 router 객체를 가져와야 합니다. 
// useRoute()는 현재 라우트 정보를 가져오는 반면, useRouter()는 라우터 인스턴스를 제공하여 페이지 이동을 제어할 수 있습니다.

const state = reactive({
    form:{            //신청서에 관한것들을 저장하는 객체
      id:0,
      title:"",
      description:"",
      createDate:"",
    },

    inputs:{       //입력에 관한것들을 저장하는 객체, 상단에서 v-model로 다 연결함, **백앤드에서 dto필드랑 이름이 같아야 한다.(ApplicationDto)
      writerName: "", 
      ageRange: 10,
      gender:"M",
      content: "", 
    },
});

(async()=>{    //이 컴포넌트가 로드될 때 무조건 실행되는 비동기 함수
    const formId=route.params.id;
    state.form=await formService.read(formId);   //Home.vue에서는 readAll()을 사용해서 배열에 객체를 담았지만, 여기서는 read()를 사용해서 객체로 바로 담는다.
    console.log(form.title, ":불러오기 완료");
})();    //📌 ***끝에 ();가 있으면 함수가 즉시 실행되고, 없으면 그냥 함수 정의만 됩니다

const submit = async() => {

    if(!state.inputs.writerName){
      window.alert("작성자명을 입력해주세요.");
      document.getElementById("writerName").focus();     // 커서를 위치시키는 곳
      return;
    }


   const result=await applicationService.save(state.inputs);
   
   console.log(result.title , "가 제출되었습니다.");
    if(result){
      window.alert("신청서가 제출되었습니다.");
      router.push("/");  //홈으로 이동
      return ;
    }else{
      window.alert("제출에 실패했습니다.");
    }
};



</script>

<style lang="scss" scoped>
.application {
  .top {
    margin-bottom: 30px;
    padding-bottom: 15px;
    border-bottom: 1px solid #ddd;
  }
  .title {
    font-size: 24px;
    font-weight: 600px;
  }.desc {
    color: orange;
  }
}
</style>
