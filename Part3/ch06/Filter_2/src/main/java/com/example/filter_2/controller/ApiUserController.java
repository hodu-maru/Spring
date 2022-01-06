package com.example.filter_2.controller;

import com.example.filter_2.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/temp")
@Slf4j  //Spring에서 log를 남길때는 log.info()를 사용해요. lombok을 사용하면 이 어노테이션을 달아주셔야 합니다.
public class ApiUserController {

    @PostMapping("")
    public User user(@RequestBody User user){

        log.info("Temp : {}",user);

        return user;

    }
}
