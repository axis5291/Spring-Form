package org.axis.form.repository;

import java.util.Optional;

import org.axis.form.entity.Form;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  FormRepository extends JpaRepository<Form, Long> {
    
  Optional<Form> findById(Long id);
    
}
