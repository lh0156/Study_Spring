package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {

        /*
            Model = Spring ui에 있는것으로써 여기에 담아서 값을 넘길 수 있다.
            return = 화면 이름
                관례상
        */
        model.addAttribute("data", "hello");
        return "hello";
    }

}
