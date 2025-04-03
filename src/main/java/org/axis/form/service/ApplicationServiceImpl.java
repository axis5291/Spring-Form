package org.axis.form.service;

import org.axis.form.dto.ApplicationDto;
import org.axis.form.repository.ApplicationRepository;
import org.springframework.stereotype.Service;

@Service
public class ApplicationServiceImpl implements ApplicationService {


    private final ApplicationRepository   applicationRepository;

    public ApplicationServiceImpl(ApplicationRepository applicationRepository){
        this.applicationRepository=applicationRepository;
    }

    @Override
    public void save(ApplicationDto applicationDto) {
       applicationRepository.save(applicationDto.toEntity());  // ApplicationDto를 Application entity로 변환하여 DB에 저장
    }
    
 
}
