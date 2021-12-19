package com.example.aop.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component  //@Bean은 클래스에는 못붙인다고 하네요~
public class TimerAop {
    @Pointcut("execution(* com.example.aop.restApiController..*.*(..))")
                            //controller 하위의 메소드들에 건 pointcut
    private void cut(){}

    @Pointcut("@annotation(com.example.aop.annotation.Timer)")
                            //@Timer 어노테이션이 설정된 메소드들에 사용할 pointcut
    private void enableTimer(){}

    @Around("cut() && enableTimer()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object result = joinPoint.proceed();
        //joinPoint의 proceed를 호출하면 실제 메소드가 실행됨. return값이 있다면 Object 타입이 리턴됨

        stopWatch.stop();

        System.out.println("total time : " + stopWatch.getTotalTimeSeconds());
        //특정 메소드를 시작하고부터 끝날때까지 걸린 시간을 출력하는 메소드
    }


}
