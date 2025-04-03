package org.axis.form.controller;

import java.util.HashMap;
import java.util.Map;

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
    public ResponseEntity<Map<String, String>> add(@RequestBody ApplicationDto applicationDto){
        applicationService.save(applicationDto);

        //제이슨 형태로 응답을 보내기 위해 아래와 같이 코딩, 프론트앤드에서 키값으로 message를 사용해서 콘솔로 출력하면된다.
         Map<String, String> response = new HashMap<>();
        response.put("message", "스프링이 보낸 메세지:신청이 이루어졌습니다.");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);


        //return new ResponseEntity<>("신청이 이루어졌습니다.", HttpStatus.CREATED);
    }

}
