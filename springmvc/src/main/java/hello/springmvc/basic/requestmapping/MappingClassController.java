package hello.springmvc.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/mapping")
public class MappingClassController {

    @GetMapping("/users")
    public String getUserList() {
        log.info("get User");
        return "ok get";
    }

    @PostMapping("/users")
    public String saveUser() {
        log.info("save User");
        return "post users";
    }

    @GetMapping("/users/{userId}")
    public String findById(@PathVariable String userId) {
        log.info("userId is {}", userId);
        return "get userId= " + userId;
    }

    @PatchMapping("/users/{userId}")
    public String updateUser(@PathVariable String userId) {
        log.info("user is change {}", userId);
        return "get userId= " + userId;
    }

    @DeleteMapping("/users/userId")
    public String deleteUser(@PathVariable String userId) {
        log.info("{} is delete User", userId);
        return "delete User" + userId;
    }

}
