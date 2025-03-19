package org.axis.form.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class FormRead {   //엔티티의 모든 정보를 고객에게 주는게 아니라 일부만 보여주기위해 만든 클래스스
    
    private Integer id;
    private String title;
    private String description;
    private LocalDateTime createDate;

        
}
