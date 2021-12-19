package com.example.ch05_moreaboutspring.DI;

import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
//이 클래스는 Bean으로 만들어서 spring container에서 관리함
public class Base64Encoder implements IEncoder{

    @Override
    public String encode(String message) {
        return Base64.getEncoder().encodeToString(message.getBytes());
    }
}
