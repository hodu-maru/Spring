package com.example.client.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class RestTemplateService {

    //http://localhost/api/server/hello URI로 호출해서
    //response를 받아올 메소드
    public String hello(){
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost")
                .path("/api/server/hello")
                .encode()
                .build()
                .toUri();

        System.out.println(uri.toString());

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.

    }
}
