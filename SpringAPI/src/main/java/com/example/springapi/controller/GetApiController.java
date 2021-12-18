package com.example.springapi.controller;

import com.example.springapi.DTO.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    @GetMapping(path = "/hello")    //http://localhost:8080/api/get/hello
    public String getHello(){
        return "get Hello";
    }

    @GetMapping("/path-variable/{str}")   //http://localhost:8080/api/get/hello/{str}
    public String pathVariable(@PathVariable(name = "str")String otherStr){
        System.out.println("PathVariable : " + otherStr);
        return otherStr;
    }

    //http://localhost:8080/api/get/query-param?user=steve&email=kyh885@gmail.com&age=25

    //Map으로 받는 방법
    @GetMapping("/query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam){

        StringBuilder sb = new StringBuilder();
        queryParam.entrySet().forEach(stringStringEntry -> {
           System.out.println( stringStringEntry.getKey());
           System.out.println( stringStringEntry.getValue());

           sb.append(stringStringEntry.getKey() +" : " + stringStringEntry.getValue() + "\n");
        });
        return sb.toString();
    }

    @GetMapping("query-param2")
    public String queryParam2(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    ){
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);

        return name + email + age;
    }
    // 명시적으로 들어올 인자들을 지정하는 방법.
    // 람다식 안써도 됨^^
    // api로 인자 전달시 type틀리면 오류날 수 있음ㅠ
    //변수가 많아지면 매번 추가해줘야됨

    @GetMapping("query-param3")
    public String queryParam2(UserRequest userRequest) {
        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());

        return userRequest.toString();
        //toString메소드를 만들어놓으면 쉽게 반환할 수 있음
    }
    //queryParam에서 들어온 api 정보를 받으면 스프링이 key객체들과 만들어놓은 dto클래스의 변수들과
    //이름 매칭을 해 객체로 반환해줌
}


