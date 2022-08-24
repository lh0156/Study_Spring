package com.oraclejava.day2;

import org.springframework.beans.factory.InitializingBean;

public class Profile implements InitializingBean {
    private String name;
    private int num = Integer.MIN_VALUE;

    public String getName() {
        return name;
    }

    //set
    //생성(Alt + Insert)

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "선수 이름: " + name + "\r\n" +
                "등 번호: " + num;
    }

    //PostConstruct랑 같은 기능
    @Override
    public void afterPropertiesSet() throws Exception {
        if (name == null ) {
            name = "어떤 선수";

        }

        if (num == Integer.MIN_VALUE) {
            System.out.println("선수 번호가 설정 되지 않았으므로 -1로 지정합니다");
            num = -1;
            throw new IllegalArgumentException("선수번호(등번호) 입력 바랍니다!");
        }

    }
}
