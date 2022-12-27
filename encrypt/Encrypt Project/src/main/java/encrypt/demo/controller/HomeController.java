package encrypt.demo.controller;

import encrypt.demo.domain.Value;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import static encrypt.demo.service.EncryptorUtils.Encryptor;


@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping(value="change", method= RequestMethod.POST)
    @ResponseBody
    public String change(Value input) throws Exception {
        String message = input.getIn();
        String passcode = input.getPc();
        String algorithm = input.getAgr();

        return Encryptor(message, passcode, algorithm);
    }




}
