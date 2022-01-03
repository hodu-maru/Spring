package com.example.handleexception.advice;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice   //rest API를 사용하는 controller
public class GlobalControllerAdvice {

    @ExceptionHandler(value = Exception.class) //예외 처리 어노테이션. 값으로 어떤 에러를 잡을지 설정. 얘는 걍 모든 예외 처리
    public ResponseEntity exception(Exception e){


        System.out.println(e.getClass().getName());
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(e.getLocalizedMessage());
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
                                    //서버에서 일어나는 에러. 구체적인 에러 내용은 일단 비움
    } //restAPI이기 때문에 반환은 ResponseEntity타입

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
                        //해당 에러가 구체적으로 어떤 에러인지 특정할 수 있으면, @ExceptionHandler의 인자로 해당 에러 클래스를
                        //지정해 에러 처리 가능
    public ResponseEntity MethodArgumentNotValidException(MethodArgumentNotValidException e){
                                                            //구체적인 에러 타입으로 인자를 받음

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

    }


}
