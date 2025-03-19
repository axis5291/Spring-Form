package org.axis.form.repository;

import java.util.Optional;

import org.axis.form.entity.Application;

import org.springframework.data.jpa.repository.JpaRepository;

public interface  ApplicationRepository extends JpaRepository<Application, Long> {
  
 
    
}
