package com.example.client.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class RestTemplateService {

    //http://localhost/api/service/hello
    //response
    public String hello(){
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/hello")
                .encode()   //안해도 되지만 파라미터가 붙으면 안정적으로 인코딩하는게 좋음
                .build()
                .toUri();

        System.out.println(uri.toString());

        RestTemplate restTemplate = new RestTemplate();
                //궁극적인 목표는 exchange를 사용하는 것.
                //getForEntitiy()는 반환형태가 responseType을 지정해줘야 함
                //getForObject()는 resoibseEntity로 받는게 아니라 우리가 지정한 제네릭 타입으로 받을 수 있음

        String result = restTemplate.getForObject(uri,String.class);    //uri에 요청,문자열로 받음
        return result;      //getForObject가 실행되는 순간이 클라이언트에서 http 서버로 붙는 순간


    }
}
