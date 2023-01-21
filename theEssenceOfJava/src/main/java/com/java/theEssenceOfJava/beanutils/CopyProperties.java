package com.java.theEssenceOfJava.beanutils;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;


public class CopyProperties {

    public static void main(String[] args) {

        Member member = new Member();
        member.setName("윤섭");
        member.setAddress("신림");
        member.setAge(27);

        MemberDto memberDto = new MemberDto();

        MemberDto resultMemberDto = copyTo(member, memberDto);

        System.out.println(resultMemberDto.getAge());
        System.out.println(resultMemberDto.getName());

    }



    public static <S, T> T copyTo (S source, T target) {

        if (source == null) {
            return null;
        }

        if (target == null) {
            return null;
        }

        BeanUtils.copyProperties(source, target);

        return target;

    }

    @Getter
    @Setter
    static class MemberDto {
        String name;
        int age;
    }

    @Getter
    @Setter
    static class Member {
        String name;
        String address;
        int age;
    }

}
