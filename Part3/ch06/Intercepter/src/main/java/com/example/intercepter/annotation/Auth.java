package com.example.intercepter.annotation;


import java.lang.annotation.*;

@Documented //해당 어노테이션을 사용하는 클래스가 javadoc과 같은 문서화 될 때,해당 어노테이션이 적용되었음을 명시하도록 한다.라고 하네요
@Retention(RetentionPolicy.RUNTIME) //이 어노테이션이 얼마나 오래 살아있을지. RUNTIME이면 걍 계속 살아있음
@Target({ElementType.TYPE,ElementType.METHOD})  //어노테이션의 사용 범위. 모든 클래스, 인터페이스, 어노테이션들과 메소드에 붙일 수 있음
public @interface Auth {


}
