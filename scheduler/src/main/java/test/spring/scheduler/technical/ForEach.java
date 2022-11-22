package test.spring.scheduler.technical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ForEach {
    public static void main(String[] args) {

        List<String> temp = new ArrayList<>();

        for(int i=0; i<20; ++i) {
            temp.add("temp" + i);
        }

        temp.stream().forEach(s -> System.out.println(s));

        String[] strArray = { "a", "p", "p", "l", "e" };
        Arrays.stream(strArray).forEach(s -> System.out.println(s));


    }
}
