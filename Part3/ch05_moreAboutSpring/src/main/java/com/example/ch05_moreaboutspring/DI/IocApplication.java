package com.example.ch05_moreaboutspring.DI;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//이 어노테이션이 붙은 클래스에서 bean들을 관리
//spring이 @Component가 붙은 클래스들을 직접 싱글톤으로 만들어 관리
public class IocApplication {

    public static void main(String args[]){
        //SpringBootApplication.run(IocApplication.class,args);
    }


}
