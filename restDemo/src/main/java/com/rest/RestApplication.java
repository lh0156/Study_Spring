package com.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import player.service.Player;


import java.util.HashMap;

@SpringBootApplication
public class RestApplication {

    public static HashMap<Long, Player> PlayerHm;


    public static void main(String[] args) {

        PlayerHm = new HashMap<>();

        Player player_one = new Player("Sonny", "Totham");
        PlayerHm.put(player_one.getId(), player_one);

        SpringApplication.run(RestApplication.class, args);

        Player player_two = new Player("Park", "Manchaster United");
        PlayerHm.put(player_two.getId(), player_two);

    }

}
