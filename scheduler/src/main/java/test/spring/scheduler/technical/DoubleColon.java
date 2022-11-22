package test.spring.scheduler.technical;

import java.util.Arrays;
import java.util.List;

public class DoubleColon {
    public String addNim(String s) {
        return s + "님";
    }

    public static void main(String[] args) {
        List<String> names = Arrays.asList("김갑순", "김갑돌");;
        DoubleColon dct = new DoubleColon();
        names.stream().forEach(x -> System.out.println(x)); // 적용 전
        names.stream().forEach(System.out::println); // 적용 전
        names.stream().map(dct::addNim).forEach(xx -> System.out.println(xx)); // 적용 후
        names.stream().map(dct::addNim).forEach(System.out::println); // 적용 후
    }
}
