package org.axis.form.service;
import  java.util.List;

import org.axis.form.dto.FormDto;

public interface  FormService {
    List<FormDto> findAll();   //Dto객체를 반환하게 한다.(엔티티의 일부분만 보여주게)
    FormDto find(Long id);  //id로  Dto객체를 반환

}
