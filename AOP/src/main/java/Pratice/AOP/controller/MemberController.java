package Pratice.AOP.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {

    @GetMapping("/get/{id}")
    public String get(@PathVariable Long id, @RequestParam String name) {
        System.out.println("Get Method가 실행됨!");
        System.out.println("Get Method {id}: " + id);
        System.out.println("Get Method {name}: " + name);
        //서비스 로직
        return id + " " + name;
    }

}
