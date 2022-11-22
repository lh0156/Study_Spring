package test.spring.scheduler.technical;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.TimeZone;

public class temp {

    public static void main(String[] args) {

        LocalDateTime modifyDate =  LocalDateTime.now().plusHours(9L);
        Calendar createDate = Calendar.getInstance(TimeZone.getTimeZone("Asia/Seoul"));



    }
}
