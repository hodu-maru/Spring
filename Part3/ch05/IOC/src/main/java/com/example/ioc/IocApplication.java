package com.example.ioc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;




@SpringBootApplication
public class IocApplication {

    public static void main(String[] args) {
        SpringApplication.run(IocApplication.class, args);

        ApplicationContext context = ApplicationContextProvider.getContext();
        Encoder encoder = context.getBean("urlEncode",Encoder.class);
        String url = "www.naver.com/books/it?page=10&size=20&name=springBoot";
        String result = encoder.encode(url);
        System.out.println(result);

    }
    @Configuration
    //한개 클래스에서 여러개의 빈을 등록하겠다는 어노테이션
    class AppConfig{

        @Bean("base64Encode")
        //빈 등록. 미리 빈에 등록시킴
        public Encoder encoder(Base64Encoder base64Encoder){
            return new Encoder(base64Encoder);
        }

        @Bean("urlEncode") //같은 encoder메소드가 두개. 빈에 인자로 다른 이름을 지어줌
        //빈 등록. 미리 빈에 등록시킴
        public Encoder encoder(UrlEncoder urlEncoder){
            return new Encoder(urlEncoder);
        }
    }
}
