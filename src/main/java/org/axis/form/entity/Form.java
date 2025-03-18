package org.axis.form.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="forms")
public class Form {    //개별신청서 클래스, 이렇게 작성을 하게 되면 디비에 실제로 테이블이 생성된다..

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, length = 100)
    private String title;

    @Column(nullable=false, length = 500)
    private String description;   //설명서

    @CreationTimestamp
    @Column(nullable=false, updatable=false)
    private LocalDateTime createDate;

    @UpdateTimestamp
    @Column(nullable=false)
    private LocalDateTime updateDate;

    
}
