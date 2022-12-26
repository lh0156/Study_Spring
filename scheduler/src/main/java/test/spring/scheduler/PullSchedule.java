package test.spring.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDateTime;

@Slf4j
@Component
@EnableAsync
public class PullSchedule {

    @Scheduled(cron = "0 0 7 1/1 * *")
    public void scheduleTaskUsingCronExpression() {

        LocalDateTime localDateTime = LocalDateTime.now();
        String temp = localDateTime.toString();
        String semiDate = ((temp.replaceAll("-", "")).replaceAll(":", ""));
        String date = semiDate.substring(0, 8);

        log.info("data: {}",date);

        String localPath = "C:\\Users\\aim\\Desktop\\Study-AimTraining\\commit";

        String code = "cd "+ localPath +" && git pull";
        execCmd(code);

    }

    public static void execCmd(String cmd) {
        try {
            Process process = Runtime.getRuntime().exec("cmd /c " + cmd);
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));


            String line = null;
            StringBuffer sb = new StringBuffer();
            sb.append(cmd);
            while ((line = reader.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }

            String s = sb.toString();
            String s2 = new String(s.getBytes("utf-8"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
