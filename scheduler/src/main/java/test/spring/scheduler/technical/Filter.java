package test.spring.scheduler.technical;

import java.util.Arrays;
import java.util.List;

public class Filter {
    public static void main(String[] args) {

        String[] strs = {"alpha", "beta", "charlie"};
        List<String> asList = Arrays.asList(strs);

        asList.stream()
                .filter(z -> z.startsWith("a"))
                .forEach(System.out::println);

    }
}
