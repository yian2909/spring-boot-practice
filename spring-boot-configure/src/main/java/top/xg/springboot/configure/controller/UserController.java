<<<<<<< HEAD
package top.xg.springboot.configure.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.xg.springboot.configure.entity.User;

/**
 * @author Lenovo
 */
@RestController
@Slf4j
public class UserController {

    @PostMapping("/users")
    public String createUser(@Valid @RequestBody User user) {
        log.info("come");
        return "用户有效";
    }
}
=======
package top.xg.springboot.configure.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.xg.springboot.configure.entity.User;

>>>>>>> 3a445c108c2cb986de68ce29000d3e6bf4ca24b3
