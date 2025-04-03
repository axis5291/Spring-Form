## Vite 설치과정과 실헹
1.임의의 이름으로 폴더를 만든뒤 (npm create vite@latest) 로 Vite 프로젝트 생성 → package.json 생성
2.바이트에 필요한 라이브러리를 설치한다. (npm install) 로 의존성 설치 → node_modules 폴더 생성
3.npm run dev로 개발 서버 실행 → 애플리케이션 실행

===============================================================================================
## ***뷰의 구조
✅ index.html → <div id="app">에 App.vue가 마운트됨.
✅ App.vue → 기본 레이아웃을 담당 (header, footer, <router-view>)
✅ <router-view> → 현재 URL에 맞는 컴포넌트를 동적으로 렌더링

뷰는 index.html을 찾아서 시작한다.
-index.html에는 부트스트랩 같은 스타일시트를 적용하게 링크형테로 설정하고, 
-따로 뷰의 router, App, 컴포넌트 등을  <script type="module" src="/src/main.js"> </script>형태로 외부에서 불러들여 뷰의 자원을 로딩한다.

index.html의 <div id="app"></div>는 Vue 애플리케이션의 "마운트" 지점. 
App.vue는 Vue 애플리케이션의 루트 컴포넌트이며, main.js에서 정의한 컴포넌트가 #app에 렌더링.

App.vue:Vue 앱의 루트 컴포넌트로, 이 안에 다른 컴포넌트나 라우터 뷰 등이 포함.

index.html의  <div id="app">위치에 App.vue의 기본 뷰 컴포넌트를 위치시키고 
App.vue에서는 header, footer와  <router-view>위치에 동적으로 뷰 컴포넌트를 순환해서 랜더링하여 보여주는 구조이다.

main.js, index.js 등은 관례적으로 그 용도가 정해진 파일명이다. 다른이름으로 쓰고 싶다면 이를 사용하는 링크항목에서 원하는 파일로 모두 수정해주어야 한다.
===============================================================================================
## Vue페이지의 기본구조
Vue 컴포넌트는 기본적으로 <template>, <script>, <style> 세 가지 블록으로 구성.

-<template> HTML과 유사한 형식으로 컴포넌트의 구조를 정의</template> 
    사용자 인터페이스(UI)를 구성하는 요소들이 이곳에 배치
    Vue의 반응형 데이터 바인딩(예: v-model, v-for, v-bind 등)을 사용하여 동적으로 렌더링할 수 있다.

-<script setup>컴포넌트의 로직과 데이터를 정의 </script>
    컴포넌트의 상태(data), 메소드(methods), 계산된 속성(computed), 라이프사이클 훅 등을 이곳에서 정의

    * script 권장되는 코드 작성 순서
        <script setup>
        // 1. Import 구문
        import { ref, computed, onMounted } from 'vue'
        
        // 2. Reactive 상태 선언
        const count = ref(0)
        const user = reactive({ name: 'Jongho', age: 25 })
        
        // 3. Computed, Watch 등 선언
        const doubledCount = computed(() => count.value * 2)

        // 4. 메서드 정의
        const increment = () => {
            count.value++
        }

        // 5. Lifecycle hooks
        onMounted(() => {
            console.log('Component mounted!')
        })

        // 6. 반환 (템플릿에서 사용될 변수나 메서드)
        return { count, increment, doubledCount }
        </script>


-<style> 컴포넌트의 스타일을 정의</style>
    Scoped 스타일을 적용하면 해당 컴포넌트에만 스타일이 적용되고, 다른 컴포넌트에 영향을 미치지 않도록 할 수 있습니다.
    SCSS, SASS, CSS 등 다양한 스타일 언어를 사용   

===============================================================================================

## 부트스트랩 적용하는 방법(위치:index.html)
https://cdnjs.com/  에서 bootstrap으로 검색한 후
https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.3/css/bootstrap.min.css   ->mins.css로 끝나는 것을 복사해서
index.html의 head 부분의 link아랫부분에 붙여넣기 하면 쓸수 있다.

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.3/css/bootstrap.min.css" integrity="sha512-jnSuA4Ss2PkkikSOLtYs8BlYIeeIK1h99ty4YfvRPAlzr377vr3CXDb7sb7eEEBYjDtcYj+AjBH3FLv5uSJuXg==" crossorigin="anonymous" referrerpolicy="no-referrer" />

===============================================================================================
## CSS 적용(위치:index.html)
public폴더의 base.css 파일 적용

<link rel="stylesheet" href="public/base.css">식으로 적용

===============================================================================================
# frontend 폴더위치에 설치할 목록
 - npm i scss:  App.vue의 <style lang="scss">로 scss문법을 쓸 수 있게 한다.
 
 -npm i axios:엑시오스 사용 

===============================================================================================
# JS파일설명
 *fontService.js:함수를 만들어서 axios를 사용하여 스프링서버에서 데이터를 읽어오게 한다.->스프링서버에  /v1/api/forms 경로로 요청하여  모든 데이터를 읽어오는 함수가 있다.
 index.js:router를 설정하여 메인뷰에서 주요켄텐츠를 동적으로 보여주게 설정한다.

===============================================================================================
# cors문제 해결을 위한 설정: vue.config.js에서 설정
 cors의 원인:프로토콜, 도메인, 포트 번호 중 하나라도 다르면 다른 출처(Cross-Origin)로 간주되어 CORS 문제가 발생함

    server: {
        proxy: {
        'v1/api': {    // v1/api/로 들어오는 요청을 백엔드(http://backend-server:8080/)로 전달
            target: 'http://localhost:8080', // 백엔드 주소
          
        },
        },
    },  //cors문제 해결을 위한 설정


===============================================================================================
# axios를 사용하게 되면 기본적으로 비동기 처리를 해주어야 한다.  (async/await이 가독성이 좋고 유지보수하기 쉬워서 추천)

# 1. async/await 방식
import axios from 'axios';

async function fetchData() {
  try {
    const response = await axios.get('https://jsonplaceholder.typicode.com/posts/1');
    console.log('데이터:', response.data);
  } catch (error) {
    console.error('에러 발생:', error);
  }
}

fetchData();


# 2.then/catch 방식 (Promise)
import axios from 'axios';

axios.get('https://jsonplaceholder.typicode.com/posts/1')
  .then(response => {
    console.log('데이터:', response.data);
  })
  .catch(error => {
    console.error('에러 발생:', error);
  });