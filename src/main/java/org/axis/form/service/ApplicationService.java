package org.axis.form.service;

import org.axis.form.dto.ApplicationDto;

public interface  ApplicationService {  //form을 작성한뒤 저장하는 역할
  void save(ApplicationDto applicationRequest);  //Application entity를 받아서 DB에 저장
  

}
