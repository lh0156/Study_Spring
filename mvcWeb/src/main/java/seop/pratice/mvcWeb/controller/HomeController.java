package seop.pratice.mvcWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import seop.pratice.mvcWeb.domain.EncryptValue.Value;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping(value="change", method= RequestMethod.POST)
    @ResponseBody
    public String change(Value input) {
        return "this is " + input.getId();
    }

}
