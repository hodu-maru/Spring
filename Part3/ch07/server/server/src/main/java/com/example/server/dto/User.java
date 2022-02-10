package com.example.server.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User { //Client의 UserResponse dto 클래스에 대응하는 클래스. 이름은 서로 달라도 됨

    private String name;
    private int age;
}
