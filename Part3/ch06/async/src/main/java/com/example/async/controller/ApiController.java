package com.example.async.controller;


import com.example.async.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final AsyncService asyncService;

    public ApiController(AsyncService asyncService){
        this.asyncService = asyncService;
    }

    @GetMapping("/hello")
    public String hello(){
        asyncService.hello();

        return "hello";
    }

}
