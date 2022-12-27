package hello.springmvc.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/mapping/users")
public class MappingClassController {

    @GetMapping
    public String getUserList() {
        log.info("get User");
        return "ok get";
    }

    @PostMapping
    public String saveUser() {
        log.info("save User");
        return "post users";
    }

    @GetMapping("/{userId}")
    public String findById(@PathVariable String userId) {
        log.info("userId is {}", userId);
        return "get userId= " + userId;
    }

    @PatchMapping("/{userId}")
    public String updateUser(@PathVariable String userId) {
        log.info("user is change {}", userId);
        return "get userId= " + userId;
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable String userId) {
        log.info("{} is delete User", userId);
        return "delete User= " + userId;
    }

}
