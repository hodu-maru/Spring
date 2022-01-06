package com.example.filter.dto;


import lombok.*;

//@Getter
//@Setter
@Data   //getter,setter,hashcode 등을 대신하는 어노테이션
@NoArgsConstructor  //getter, setter, 기본 생성자. -> 어노테이션만으로 클래스 내부에 따로 만들지 않아도 생성됨
@AllArgsConstructor //전체 인자를 받는 생성자
public class User {

    private String name;
    private int age;
}
