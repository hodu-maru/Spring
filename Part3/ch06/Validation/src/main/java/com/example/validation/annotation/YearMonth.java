package com.example.validation.annotation;


import com.example.validation.validater.YearMonthValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Constraint(validatedBy = {YearMonthValidator.class})   //이 클래스로 검사함
//valid어노테이션을 만드는데 필요한 어노테이션들. 다른 어노테이션에서 긁어오기
//Target은 이 어노테이션을 달 수 있는 애들, retention은 생명주기

public @interface YearMonth {

    String message() default "yyyyMM 형식에 맞지 않습니다요";
    //default값으로 지정된 error message

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    String pattern() default "yyyyMMdd";

}
