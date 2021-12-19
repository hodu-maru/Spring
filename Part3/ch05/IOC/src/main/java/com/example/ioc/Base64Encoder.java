package com.example.ioc;

import org.springframework.stereotype.Component;

import java.util.Base64;

@Component("useBase64")
//이 클래스는 Bean으로 만들어서 spring container에서 관리함
public class Base64Encoder implements com.example.ioc.IEncoder {

    @Override
    public String encode(String message) {
        return Base64.getEncoder().encodeToString(message.getBytes());
    }
}
