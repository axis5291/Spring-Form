package org.axis.form.dto;

import org.axis.form.entity.ApplicationEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicationDto {

    private String writerName;
    private String content;
    private Character gender;
    private Integer ageRange;

    public ApplicationEntity toEntity() {
        return  ApplicationEntity.builder()
                .writerName(this.writerName)
                .content(this.content)
                .gender(this.gender)
                .ageRange(this.ageRange)
                .build();
    }

 }
//****ApplicationEntity애 @Builder가 붙어 있음
// `@Builder`가 있는 경우, `builder()` 메서드를 사용하여 객체를 생성할 수 있다.  
// `@Setter`와 유사하게 특정 필드의 값을 지정할 수 있지만,  
// `@Builder`는 모든 필드를 지정할 필요 없이 일부 속성만 선택적으로 설정할 수 있다.  

// `@Setter`를 사용하면 객체를 생성한 후에도 `setXxx()` 메서드를 통해 값을 변경할 수 있지만,  
// `@Builder`는 아래와 같이 객체를 생성하면서 필드 값을 할당하기 때문에,  
// 한 번 생성된 객체의 값을 변경할 수 없다.  

// User user = User.builder()
//     .id(1L)
//     .name("종호")
//     .age(25)
//     .build(); // 객체 생성 완료

// 즉, `@Builder`를 사용하면 **객체가 불변(immutable)하게 유지되므로, 동시성 문제를 방지하고 안전한 코드 작성이 가능하다.

