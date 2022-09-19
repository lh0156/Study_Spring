package com.rest.player.controller;

import java.util.HashMap;

import com.rest.RestApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import player.service.Player;

@RestController
@RequestMapping(value="/player")
public class PlayerController {

    @RequestMapping(value="/", method=RequestMethod.GET)
    public HashMap<Long, Player> getAllPlayers(){
        return RestApplication.PlayerHm;
    }

}
