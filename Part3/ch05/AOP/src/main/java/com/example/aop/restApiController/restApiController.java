package com.example.aop.restApiController;

import com.example.aop.annotation.Decode;
import com.example.aop.annotation.Timer;
import com.example.aop.dto.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class restApiController {

    @GetMapping("/get/{id}")
    public String get(@RequestParam String name, @PathVariable Long id){

        return id + " " + name;

    }

    @PostMapping("/post")
    public User post(@RequestBody User user){

        return user;

    }

    @Timer
    @DeleteMapping("/delete")
    public void delete(){

        //db logic -> 2초 소요
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Decode
    @PutMapping("/put")
    public User put(@RequestBody User user){

        System.out.println("put");
        System.out.println(user);

        return user;

    }
}

//방금 메소드는 get과 post 두개였지만, 실무에서는 ㅈㄴ 많을거임. 10개도 넘음
//각 메소드마다 println 다 일일이 찍을거임?
//Aop로 한번에 몰아놓을 수 있음
//TimerAop 클래스를 따로 만들어서 일관되게 시간을 찍는 부가기능을 따로 정의함

