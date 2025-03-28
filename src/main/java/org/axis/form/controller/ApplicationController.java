package org.axis.form.controller;

import org.axis.form.dto.ApplicationDto;
import org.axis.form.service.ApplicationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class ApplicationController {
    public final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService){
        this.applicationService=applicationService;
    }

    @PostMapping("/api/applications")
    public ResponseEntity<String> add(@RequestBody ApplicationDto applicationDto){
        applicationService.save(applicationDto);
        return new ResponseEntity<>("신청이 이루어졌습니다,", HttpStatus.CREATED);
    }

}
