import axios from 'axios'

export default {
       
        async readAll() {   //스프링서버에  /v1/api/forms 경로로 요청하여  모든 데이터를 읽어오는 함수
            const res = await axios.get("/v1/api/forms");
            return res.data;
        },

        async read(id){
            const res = await axios.get(`/v1/api/forms/${id}`);   //백틱으로 입력해야 id값을 받아올 수 있다.
            console.log(res.data, "id값을 받아옴");
            return res.data;
        }
    }
 
