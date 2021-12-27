package com.example.validation.validater;

import com.example.validation.annotation.YearMonth;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class YearMonthValidator implements ConstraintValidator<YearMonth,String> {
    //ConstraintValidator를 구현하는 클래스.인자로 첫번째는 사용할 어노테이션을, 어노테이션에 들어오는 문자열 인자 값을 받음

    private String pattern;
    //어노테이션에 인자로 들어오는 문자열. YearMonth 어노테이션이니까 "yyyyMM"이 들어오겠죠?

    @Override
    public void initialize(YearMonth constraintAnnotation) {
        this.pattern = constraintAnnotation.pattern();
        //어노테이션 초기화 시, 어노테이션에 인자로 들어온 문자열을 등록
        //YearMonth 어노테이션은 default값으로 "yyyyMM"이 지정되어 있음
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        //value = "yyyyMMdd"
        try {
            LocalDate localDate = LocalDate.parse(value + "01", DateTimeFormatter.ofPattern(this.pattern));
            //locatDate는 yyyyMMdd 형식임. 총 8글자가 아니면 오류가 나는데, value는 yyyyMM이니까 뒤에 그냥 01을 붙여서 완성
        } catch (Exception e){
            return false;
        }
        return true;

    }
}
