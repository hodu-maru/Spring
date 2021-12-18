package com.example.springapi.DTO;

public class UserRequest {

    private String name;
    private String email;
    private int age;
    //1.사용할 변수들을 선언해 준 뒤


    //2.모든 변수들의 getter와 setter 메소드를 만들어준다.
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "UserRequest{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
