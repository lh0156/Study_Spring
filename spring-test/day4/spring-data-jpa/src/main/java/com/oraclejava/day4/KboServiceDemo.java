package com.oraclejava.day4;

import com.oraclejava.day4.config.JpaConfig;
import com.oraclejava.day4.entity.Kbo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;

public class KboServiceDemo {
    public static void main(String[] args) {
        GenericApplicationContext ctx =
                new AnnotationConfigApplicationContext(JpaConfig.class);

        KboService kboService = ctx.getBean(KboService.class);
        //List<Kbo> kboList = kboService.findAll();
        //List<Kbo> kboList = kboService.findByTeamA("Hanwha");

        List<Kbo> kboList = kboService.findByTeamAAndTeamB("Hanwha", "Kia");
        System.out.println("순번   |   원정팀   |    홈팀   |   승자");
        for (Kbo kbo : kboList) {
            System.out.println(kbo.getNo() + "    |  "
                    + kbo.getTeamA() + "    |  "
                    + kbo.getTeamB() + "    |  "
                    + kbo.getWinner());
        }

        ctx.close();
    }
}
