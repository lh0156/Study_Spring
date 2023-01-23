package com.java.theEssenceOfJava.soyeonstudy;

import com.java.theEssenceOfJava.soyeonstudy.domain.Pet;
import com.java.theEssenceOfJava.soyeonstudy.dto.response.PetDto;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Field;

public class PetService {

    public static void main(String[] args) {

         String jong = "pome";

        boolean isValidFlag = false;
        for(Field field : seopmember.class.getDeclaredFields()) {
            if (field.getName().equals(jong)) {
                isValidFlag = true;
                break;
            }
        }

        if (isValidFlag) {
            System.out.println("존재합니다");
        } else {
            System.out.println("존재하지 않습니다.");
        }

    }

    public static <S, T> T copyTo(S source, T target) {
        BeanUtils.copyProperties(source, target);

        return target;
    }

    static class seopmember {
        String pome;

        String maltiz;
    }



}
