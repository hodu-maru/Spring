package com.example.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect //aop를 사용하는 클래스
@Component  //spring이 관리하는 클래스
public class ParameterAop {

    @Pointcut("execution(* com.example.aop.restApiController..*.*(..))")
    //pointcut 메소드임을 선언하는 어노테이션
                        //com.example.aop.restApiController 하위에 있는 모든 메소드를 aop로 보겠다 라는 문구래요.
                        //ㅅㅂ 짬때림 알아서 찾아서 쓰래
    private void cut(){}

    //@Before("cut()")    //아래 메소드를 cut()메소드 실행 이전에 실행하겠다.
    public void before(JoinPoint joinPoint){    //들어가는 지점에 대한 정보를 갖는 joinPoint 인자

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println(method.getName());

        Object args[] = joinPoint.getArgs();    //메소드에 들어가고 있는 인자들을 받아볼 수 있음

        for(Object obj : args){
            System.out.println("type : " + obj.getClass().getSimpleName());
            System.out.println("value : " + obj);
        }

    }

    //@AfterReturning(value = "cut()", returning = "obj")    //아래 메소드를 cut()메소드가 성공적으로 호출되고 리턴한 후에 실행하겠다.
                                    //받을 obj를 이름을 맞춰서 returning으로 받아줘야 함.
    public void Return(JoinPoint joinPoint,Object obj){     //@AfterReturning 메소드는 Object도 받을 수 있음
        System.out.println("post method : " + obj);
        System.out.println(obj);

    }
}
