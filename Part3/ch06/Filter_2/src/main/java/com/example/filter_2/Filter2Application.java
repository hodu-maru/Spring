package com.example.filter_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan   //filter를 사용하기 위핸 어노테이션
public class Filter2Application {

    public static void main(String[] args) {
        SpringApplication.run(Filter2Application.class, args);
    }

}
