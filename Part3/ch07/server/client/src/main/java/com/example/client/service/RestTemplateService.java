package com.example.client.service;

import com.example.client.Dto.UserRequest;
import com.example.client.Dto.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class RestTemplateService {

    //http://localhost/api/service/hello
    //response
    public UserResponse hello(){
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/hello")
                .queryParam("name","명성")
                .queryParam("age",22)   //queryParam을 싣는 방법. path뒤에 붙여줌
                .encode()   //안해도 되지만 파라미터가 붙으면 안정적으로 인코딩하는게 좋음
                .build()
                .toUri();

        System.out.println(uri.toString());

        RestTemplate restTemplate = new RestTemplate();
                //궁극적인 목표는 exchange를 사용하는 것.
                //getForEntitiy()는 반환형태가 responseType을 지정해줘야 함
                //getForObject()는 resoibseEntity로 받는게 아니라 우리가 지정한 제네릭 타입으로 받을 수 있음

//        String result = restTemplate.getForObject(uri,String.class);    //uri에 요청,문자열로 받음
             //getForObject가 실행되는 순간이 클라이언트에서 http 서버로 붙는 순간
                            //client에서 호출하기 때문에 getForObject를 사용
                            //response를 받을 형태를 지정(String.class)

        ResponseEntity<UserResponse> result = restTemplate.getForEntity(uri,UserResponse.class);
                                            //가져오겠다의 get이 아니라 get방식으로 받겠다는 의미
                                            //Entity형식으로 가져옴

        System.out.println(result.getStatusCode()); //http status를 참조
        System.out.println(result.getBody());   //responseBody의 내용을 참조
        //getForEntity()로 받는


        return result.getBody();

    }

    public UserResponse post(){
        //http://locahost:9090/api/server/user/{userId}/name/{userName}
        //유저 등록하기

        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090") //여기에다가 호출할 예정
                .path("api/server/user/{userId}/name/{userName}")   //중괄호로 감싸기!
                .encode()
                .build()
                .expand(100)    //중괄호 부분과 매칭되는 값
                .expand("steve")
                .toUri();

        System.out.println(uri);

        //http body -> object -> object mapper -> json -> rest template -> http body json
        UserRequest req = new UserRequest();
        req.setName("steve");
        req.setAge(10);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserResponse> response = restTemplate.postForEntity(uri,req,UserResponse.class);

        System.out.println(response.getStatusCode());
        System.out.println(response.getHeaders());
        System.out.println(response.getBody());

        return response.getBody();
    }
}
