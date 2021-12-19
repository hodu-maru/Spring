package com.example.ioc;

public interface IEncoder {
    //③  인코더 인터페이스를 만들어 encode()메소드를 구현하게 함
    public String encode(String message);
    //이미 만든 인코더 클래스들은 implement만 하면 됨
}
