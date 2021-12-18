package com.example.springapi.controller;

import com.example.springapi.DTO.PostRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class PostApiController {

    @PostMapping("/post")
    public void post(@RequestBody Map<String,Object> requestData){
                    //body로 받을때는 어노테이션 붙어야 함.

        requestData.entrySet().forEach(stringObjectEntry -> {
            System.out.println(stringObjectEntry.getKey());
            System.out.println(stringObjectEntry.getValue());
        });
    }

    @PostMapping("/post2")
    public void post2(@RequestBody PostRequestDto postRequestDto){
        System.out.println(postRequestDto.toString());
    }
}
