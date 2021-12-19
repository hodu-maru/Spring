package com.example.springapi.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class mapperUser {
    private String name;
    private int age;

    @JsonProperty("phone_number")
    private String phoneNumber;

    public mapperUser(){
        this.name = null;
        this.age = 0;
        this.phoneNumber = null;
    }
    public mapperUser(String name, int age,String phoneNumber) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "mapperUser{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
