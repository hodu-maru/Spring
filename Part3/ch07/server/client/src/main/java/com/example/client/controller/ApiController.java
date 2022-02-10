package com.example.client.controller;

import com.example.client.Dto.UserResponse;
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

    @GetMapping("/hello")
    public UserResponse getHello(){
        return restTemplateService.hello();     // api/client에 get형태로 요청이 들어오면 restTemplate를 통해 서버를 호출, 응답을 내림

    }
}
//get api를 쓸 때, 어떤 서버가 어떤 데이터를 준다고 정해지면, json표준 규격을 보고 클래스 작성
//이후 rest템플릿을 통해 get, post등의 형태로 데이터를 주고받음
//get은 주소만 호출하면 됨. 근데 post는 body를 실어야 하기 때문에 따로 해줘야된다는듯