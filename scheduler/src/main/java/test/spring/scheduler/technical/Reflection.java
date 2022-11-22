package test.spring.scheduler.technical;

import java.util.ArrayList;
import java.util.List;

public class Reflection {
    public static void main(String[] args) {

        Class<? extends String> aClass = "Filter".getClass();
        System.out.println(aClass);


        byte[] temp = new byte[1024];
        Class<? extends byte[]> aClass1 = temp.getClass();
        System.out.println(aClass1);

        List<String> userId = new ArrayList<>();

        for(int i=0; i<10; ++i) {
            userId.add(i + "");
        }


    }
}
