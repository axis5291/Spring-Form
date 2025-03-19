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
    public ResponseEntity<?> read(@PathVariable("id") Long id) {
        try {
            FormDto formDto = formService.find(id);
            return new ResponseEntity<>(formDto, HttpStatus.OK);
        } catch (RuntimeException e) {  
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);  
        }
    }

    //아래것을  쓰면 콘솔에서 에러가 뜨는데, 수정된 것 위에 것을 쓰면 웹페이지에 에러메세지가 출력된다.
    // @GetMapping("/api/forms/{id}")     
    // public ResponseEntity<FormDto> read(@PathVariable("id") Long id){
    // FormDto formDto=formService.find(id);
    //     if(formDto==null)
    //         return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    // return new ResponseEntity<>(formDto, HttpStatus.OK);   
    // }

 
}

