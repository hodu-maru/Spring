package com.example.aop.aop;


import com.example.aop.dto.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Aspect
@Component
public class DecodeAop {

    @Pointcut("execution(* com.example.aop.restApiController..*.*(..))")
    private void cut(){}

    @Pointcut("@annotation(com.example.aop.annotation.Decode)")     //@Decode 어노테이션 달린 메소드에 적용
    private void enableDecode(){}

    //전은 decode를 해서 들여오고, 후는 incode를 해서 내보낼거임

    @Before("cut() && enableDecode()")
    //전. decode 과정
    public void before(JoinPoint joinPoint) throws UnsupportedEncodingException {

        Object args[] = joinPoint.getArgs();
        //joinPoint를 통해 가져온 메소드 인자값을 Object args[] 배열로 담아옴

        for(Object arg : args) {    //받아온 배열에 대해
            if (arg instanceof User) {     //if(Object로 받아온 arg의 실제 타입이 User 이면)

                //User user = User.class.cast(arg);
                User user = (User) arg; //object에서 User 타입으로 형변환 후

                String base64Email = user.getEmail();   //메일 주소만 string으로 꺼내옴
                String email = new String(Base64.getDecoder().decode(base64Email),"UTF-8");
                                //메일 주소를 base64로 디코딩 수행, UTF-8로

                user.setEmail(email);   //디코딩 한 메일주소를 user에 다시 set해줌
            }
        }
    }

    @AfterReturning(value = "cut() && enableDecode()", returning = "returnObj")
    public void afterReturn(JoinPoint joinPoint,Object returnObj){

        if(returnObj instanceof User){

            User user = (User) returnObj;

            String email = user.getEmail();

            String base64Email = new String(Base64.getEncoder().encodeToString(email.getBytes(StandardCharsets.UTF_8)));

            user.setEmail(base64Email);
        }

    }
}
