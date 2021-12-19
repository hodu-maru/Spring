package com.example.ch05_moreaboutspring.DI;

public class Encoder {
    //① 인코더 클래스 만들어 드렸습니다

    private IEncoder iEncoder;
    //④ 클래스가 갖고있는 객체

    public Encoder(IEncoder iEncoder){
        this.iEncoder = iEncoder;
    }

    public String encode(String message){
        return iEncoder.encode(message);
    }
}
