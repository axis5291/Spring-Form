
## 부트스트랩 적용하는 방법
https://cdnjs.com/  에서 bootstrap으로 검색한 후
https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.3/css/bootstrap.min.css   ->mins.css로 끝나는 것을 복사해서
index.html의 head 부분의 link아랫부분에 붙여넣기 하면 쓸수 있다.

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.3/css/bootstrap.min.css" integrity="sha512-jnSuA4Ss2PkkikSOLtYs8BlYIeeIK1h99ty4YfvRPAlzr377vr3CXDb7sb7eEEBYjDtcYj+AjBH3FLv5uSJuXg==" crossorigin="anonymous" referrerpolicy="no-referrer" />

===============================================================================================
# frontend 폴더위치에 설치할 목록
 - npm i sass:  App.vue의 <style lang="scss">로 scss문법을 쓸 수 있게 한다.
 
 -npm i axios:엑시오스 사용 

===============================================================================================
# JS파일설명
 fontService.js:함수를 만들어서 axios를 사용하여 서버에 데이터를 읽어오게 한다.
 index.js:router를 설정하여 메인뷰에서 주요켄텐트를 동적으로 보여주게 설정한다.

===============================================================================================
# cors문제 해결을 위한 설정: vue.config.js에서 설정
 cors의 원인:프로토콜, 도메인, 포트 번호 중 하나라도 다르면 다른 출처(Cross-Origin)로 간주되어 CORS 문제가 발생함

    server: {
        proxy: {
        'v1/api': {    // v1/api/로 들어오는 요청을 백엔드(http://backend-server:8080/)로 전달
            target: 'http://localhost:8080', // 백엔드 주소
            changeOrigin: true, // CORS 문제 해결
            rewrite: (path) => path.replace(/^\/api/, ''), // /api를 제거하고 백엔드로 전달
        },
        },
    },  //cors문제 해결을 위한 설정정




