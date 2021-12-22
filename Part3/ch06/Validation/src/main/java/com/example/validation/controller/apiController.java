package com.example.validation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class apiController {

    @PostMapping("/post")
    public ResponseEntity user(@Valid @RequestBody User user, BindingResult bindingResult){
                                //validation을 적용할 객체임을 정의.
                                //올바른 이메일 형식이 아닐 경우error처리
                                //BindingResult : 형식 오류를 일으키는 값을 받는 객체 타입

        if(bindingResult.hasErrors()){
            StringBuilder sb = new StringBuilder();
            bindingResult.getAllErrors().forEach(objectError -> {
                var field = (FieldError)objectError;
                String message = objectError.getDefaultMessage();

                   System.out.println("field : " + field.getField());
                   System.out.println(message);

               sb.append("field : " + field.getField());
               sb.append("\nmessage : " + message);

            });
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());

        }
        System.out.println(user);


        return ResponseEntity.ok(user);
    }
    //이렇게만 하고 talentAPI돌리면 잘 돌아가긴 함. 근데 ㅈ같이 입력하면 ㅈ같이 나옴
    //->아니 당연하지 니가 ㅈ같이 입력했는데
    //->ㄴㄴ 알아서 걸러주셈
    //if문으로 거를순 있음. 근데 ㄹㅇ 한도끝도 없어

    //핸드폰번호 정규식 : "^\\d{2,3}-\\d{3,4}-\\d{4}$"
}
