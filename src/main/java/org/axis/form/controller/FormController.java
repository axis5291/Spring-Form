package org.axis.form.controller;

import java.util.List;

import org.axis.form.dto.FormDto;
import org.axis.form.service.FormService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class FormController {

    private final FormService formService;

    public FormController(FormService formService){
        this.formService = formService;
    }

    @GetMapping("/api/forms")   //http://localhost:8080/v1/api/forms 으로 접속
    public ResponseEntity<List<FormDto>> readAll(){
        List<FormDto> formDto=formService.findAll();
        return new ResponseEntity<>(formDto, HttpStatus.OK);   
    }

    @GetMapping("/api/forms/{id}")
    public ResponseEntity<FormDto> read(@PathVariable("id") Long id){
        FormDto formDto=formService.find(id);
        if(formDto==null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(formDto, HttpStatus.OK);   
    }
}

