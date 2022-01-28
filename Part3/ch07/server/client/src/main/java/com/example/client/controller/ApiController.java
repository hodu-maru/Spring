package com.example.client.controller;

import com.example.client.service.RestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/client")
public class ApiController {

    @Autowired  //미리 만들어둔 Service를 객체로 선언한 뒤, 스프링에 등록시켜 사용하는 어노테이션
    private RestTemplateService restTemplateService;

    @GetMapping("")
    public String getHello(){
        return restTemplateService.hello();     // api/client에 get형태로 요청이 들어오면 restTemplate를 통해 서버를 호출, 응답을 내림

    }
}
