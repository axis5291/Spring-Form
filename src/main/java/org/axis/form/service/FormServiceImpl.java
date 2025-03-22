package org.axis.form.service;

import java.util.ArrayList;
import java.util.List;

import org.axis.form.dto.FormDto;
import org.axis.form.entity.FormEntity;
import org.axis.form.repository.FormRepository;
import org.springframework.stereotype.Service;
//jpa레포지토리를 불러와서 FormService에서 정의한 메서드안에 jpa에서 제공하는 메서드를 활용하는 방식이다.
//여기서는 jpa메서드로 엔터티객체로 가져와서 dto객체로 변환후  여러 dto객체들로 담은 리스트 형태와 하나의 dto객체를 반환하는 베서드가 있다.

@Service
public class FormServiceImpl implements FormService {

    private final FormRepository formRepository;

    public FormServiceImpl(FormRepository formRepository) {
        this.formRepository = formRepository;
    }  //생성자 주입

    @Override   
    public List<FormDto> findAll(){   //Dto객체들을 List에 담아 반환하게 한다.(엔티티의 일부분만 보여주게)
      List<FormDto> formDtos = new ArrayList<>();  // FormDto 객체들을 담을 리스트 생성
      List<FormEntity> formEntitys = formRepository.findAll(); // DB에서 모든 FormEntity 조회
      //***DB의 각 행이 하나의 객체(FormEntity)이고, 그 객체들을 리스트(List<FormEntity>)에 담는다

        for (FormEntity formEntity : formEntitys) { // formEntitys 리스트에서 하나씩 formEntity객체 하나로 꺼낸다.
            formDtos.add(formEntity.toFormDto());   // formEntity.toFormDto()를 사용하여 FormEntity를 FormDto로 변환.
        }
        
     return formDtos; // 변환된 FormDto 리스트 반환
    }

//***** 🔥 왕 중요!! *****
// formRepository.findAll()은 DB에서 데이터를 조회한 후, JPA가 각 행(Row)을 FormEntity 객체로 변환하여 리스트(List<FormEntity>)로 반환한다.
// 따라서 formEntity는 이미 FormEntity 타입이므로, formEntity.toFormDto()와 같이 FormEntity 클래스의 인스턴스 메서드를 바로 사용할 수 있다!


    @Override
    public FormDto find(Long id) {    // id를 이용해 FormDto 객체를 반환하는 메서드
        return formRepository.findById(id)    // formRepository에서 주어진 id로 FormEntity를 찾음 (Optional<FormEntity> 반환)
                  .map(FormEntity::toFormDto) // Optional이 비어있지 않다면 FormEntity의 toFormDto() 메서드를 호출해 FormDto로 변환
                  .orElseThrow(() -> new RuntimeException("FormServiceImpl에서 메세지:해당 ID의 데이터를 찾을 수 없습니다."));  
                                              // Optional이 비어있다면 예외를 발생시켜 "해당 ID의 데이터를 찾을 수 없습니다."라는 메시지를 반환
    }
        
}

//*중간연산은 결과가 있으면 다음 연산에 넘기고 없어도 없는데로 넘기고 최종연산은 중간연산의 결과에 따라 최종적으로 수행하는 것으로 이해
