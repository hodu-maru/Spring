package com.example.springapi.controller;

import com.example.springapi.DTO.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class responseApiController {

    //text
    @GetMapping("/text")
    public String text(@RequestParam String account){
        return account;
    }
    //그냥 string으로 받아와서 string으로 반환하는 경우
    //반환형이 text/plain으로 표시


    //response는 일반적으로 JSON의 형태로 가장 많이 반환된다.
    //JSON
    @PostMapping("/json")
    public User json(@RequestBody User user){
        return user;
    }
    //우리는 User 객체로 받아서 User 객체로 반환했는데, content-type은 json반환되었다고 뜸 ..?
    //실제로 request가 오면(json형태로), req는 object mapper을 통해 object로 바뀌어서 메소드를 타고,
    //메소드가 object를 반환하면 object mapper를 통해 json으로 바뀌어서 response가 나감

    //put은 리소스를 수정하는 동작은 200, 새로 생성하는 경우는 201을 출력함
    //이때, 응답으로 나가는 숫자를 메소드에서 임의로 지정할 수 있음
    @PutMapping("/put")
    public ResponseEntity<User> put(@RequestBody User user){
            //위 클래스의 제네릭으로 반환할 객체 타입을 지정

        return ResponseEntity.status(HttpStatus.CREATED).body(user);
                //생성시 출력 숫자인 201을 지정, body에 반환할 객체를 담음
    }


}
