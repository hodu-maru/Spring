package com.example.ioc;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Encoder {
    //① 인코더 클래스 만들어 드렸습니다

    private IEncoder iEncoder;
    //④ 클래스가 갖고있는 객체

    public Encoder(IEncoder iEncoder){
        this.iEncoder = iEncoder;
    }
    //에러. 어째서? 빈은 Spring에서 하나만 있으면 바로 맞춰주지만, 두개 이상이여서 뭘 쓸지 모르겠으면
    //에러 뜸
    //@Qualifier 어노테이션에 인자로 결정
    //일반적으로 앞글자를 소문자로 바꾼 이름을 사용, 다른 이름을 지정하고 싶으면 @Component에 문자열 인자로 주면 됨

    public void setIEncoder(IEncoder iEncoder){
        this.iEncoder = iEncoder;
    }

    public String encode(String message){
        return iEncoder.encode(message);
    }
}
