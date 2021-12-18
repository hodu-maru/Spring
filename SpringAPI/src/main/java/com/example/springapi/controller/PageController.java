package com.example.springapi.controller;


import com.example.springapi.DTO.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.beans.PropertyDescriptor;


//spring에서는 json형태뿐만 아니라 웹 페이지(html 파일)의 형태로도 response가 가능



@Controller
public class PageController {

    @RequestMapping("/main")
    public String main(){
        return "main.html";
    }

    //ResponseEntitiy


    //@Controller 어노테이션은 반환값이 String인 메소드에 대해서는 리소스를 찾게 되지만,
    //@ResponseBody 어노테이션이 붙은 메소드에서는 말그대로 Body를 만들어서 반환하게 됨.
    @ResponseBody
    @GetMapping("/user")
    public User user(){
        var user = new User();
        //타입 추론. 유용하긴한데,,굳이?
        user.setName("jin hyun");
        user.setAddress("패스트캠퍼스");

        return user;
    }
    //이대로 그냥 api를 돌리면 age값이 0으로 나옴. 왜냐? int형의 기본값이 0이기 때문.근데 0살은 아니잖슴?
    //그래서 제대로 null로 찍히려면 User 선언시 타입을 Integer로 해줘야 함
    //워메시벌 User클래스의 get메소드도 제대로 Integer로 바꿔줘야 함.
}
