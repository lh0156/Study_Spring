package com.oraclejava.day5.controller;

import com.oraclejava.day5.entity.Kbo;
import com.oraclejava.day5.mapper.KboMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KboController {

    private static Logger logger =
            LoggerFactory.getLogger(KboController.class);

    @Autowired
    private KboMapper kboMapper;

    @GetMapping(path = {"/", "/search"})
    public String listAll(Model model, String awayTeam,
                          String homeTeam) {
        logger.info("listAll");
        if (awayTeam != null && homeTeam != null) {
            logger.info("awayTeam:" + awayTeam);
            logger.info("homeTeam:" + homeTeam);
            model.addAttribute("games",
                    kboMapper.searchAwayHome(awayTeam, homeTeam));
        } else {
            model.addAttribute("games",
                    kboMapper.selectAll());
        }
        return "index";
    }
}
