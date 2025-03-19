package org.axis.form.service;

import java.util.ArrayList;
import java.util.List;

import org.axis.form.dto.FormDto;
import org.axis.form.entity.FormEntity;
import org.axis.form.repository.FormRepository;
import org.springframework.stereotype.Service;

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

        for (FormEntity formEntity : formEntitys) { // formEntitys 리스트를 하나씩 순회
            formDtos.add(formEntity.toFormDto()); // 각 FormEntity를 FormDto로 변환하여 리스트에 추가
        }
        
     return formDtos; // 변환된 FormDto 리스트 반환
    }

    @Override
    public FormDto find(Long id) {    // id를 이용해 FormDto 객체를 반환하는 메서드
        return formRepository.findById(id) // formRepository에서 주어진 id로 FormEntity를 찾음 (Optional<FormEntity> 반환)
                  .map(FormEntity::toFormDto) // Optional이 비어있지 않다면 FormEntity의 toRead() 메서드를 호출해 FormDto로 변환
                  .orElseThrow(() -> new RuntimeException("FormServiceImpl에서 메세지:해당 ID의 데이터를 찾을 수 없습니다."));   // Optional이 비어있다면 예외를 발생시켜 "해당 ID의 데이터를 찾을 수 없습니다."라는 메시지를 반환
    }
    
    
    
}
