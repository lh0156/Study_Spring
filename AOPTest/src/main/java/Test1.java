import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Test1 {

    @GetMapping("/echo")
    public String echo(@RequestParam String message) {

        System.out.println("echo parameter = " + message);

        // 비즈니스 로직 수행 ..
        System.out.println("echo return = " + message);

        return message;
    }



}
