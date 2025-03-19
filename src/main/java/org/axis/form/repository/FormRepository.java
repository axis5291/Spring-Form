package org.axis.form.repository;

import org.axis.form.entity.FormEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  FormRepository extends JpaRepository<FormEntity, Long> {
    

      
}
