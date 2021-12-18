package com.example.springapi.controller;

import com.example.springapi.DTO.PutRequestDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PutApiController {

    @PutMapping("/put/{userId}")
    public PutRequestDto put(@RequestBody PutRequestDto putRequestDto, @PathVariable String userId){
        System.out.println(putRequestDto);
        System.out.println(userId);


        return putRequestDto;
    }
}
