package hello.core.optional;

import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {

        //Optional의 value가 무조건 Null일 경우
        Optional<String> option = Optional.empty();

        //Optional의 value가 절때 Null이 아닐 경우
        Optional<String> option2 = Optional.of("myOptional");

        //Optional의 value가 절때 Null일수도 있고 아닐수도 있는 경우
        Optional<String> option3 = Optional.ofNullable("myOptional");



    }
}
