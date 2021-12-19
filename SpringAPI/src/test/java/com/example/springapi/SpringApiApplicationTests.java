package com.example.springapi;

import com.example.springapi.DTO.mapperUser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringApiApplicationTests {

    @Test
    void contextLoads() throws JsonProcessingException {
        System.out.println("-------------");

        //object mapper는 텍스트 형태의 json을 object로 바꿔주고, object를 text형태의 json으로 바꿔줌

        var objectMapper = new ObjectMapper();

        //object -> text
        var user = new mapperUser("jinhyun",25,"010-2340-6775");

        var text = objectMapper.writeValueAsString(user);
                                        //object를 string으로 바꾸는 메소드

        System.out.println(text);

        //text -> object

        var objectUser = objectMapper.readValue(text,mapperUser.class);
                                        //첫번째는 바꾸려는 json text를, 두번째는 바꾸려는 클래스 타입.class를 넣어준다.
        System.out.println(objectUser);


    }

}
