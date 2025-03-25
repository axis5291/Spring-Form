import axios from 'axios'

export default {
       //서버에 요청하여  모든 데이터를 읽어오는 함수
        async readAll() {
            const res = await axios.get("/v1/api/forms");
            return res.data;
        },
    }
 
