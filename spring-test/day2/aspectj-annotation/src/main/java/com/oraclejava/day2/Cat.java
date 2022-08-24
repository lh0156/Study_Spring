package com.oraclejava.day2;

import org.springframework.stereotype.Component;

@Component
public class Cat {

    private String breed; //품종(혈통)

    public void setBreed(String breed) {

        if (breed.equals("한국고양이")) {
            throw new IllegalArgumentException("한국 고양이는 입력하실 수 없습니다.");
        }
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    public void speak() {
        System.out.println("아년ㅇ하세요 저는 " + breed + "에요");
        System.out.println("야옹");
    }

}
