package com.oraclejava.day3.controller;

import com.oraclejava.day3.dao.UserInfoDao;
import com.oraclejava.day3.entity.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RequestMapping("/users")
@Controller
public class UserInfoController {

    private static final Logger logger = LoggerFactory.getLogger(UserInfoController.class);

    @Autowired
    private UserInfoDao userInfoDao;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        logger.info("userinfo list");
        List<UserInfo> users = userInfoDao.findAll();
        model.addAttribute("users", users);

        return "userinfo/list";
    }

}
