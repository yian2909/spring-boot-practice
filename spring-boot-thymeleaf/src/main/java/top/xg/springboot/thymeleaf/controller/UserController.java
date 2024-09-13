package top.xg.springboot.thymeleaf.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.xg.springboot.thymeleaf.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    private List<User> users = new ArrayList<>();

    @GetMapping("/user")
    public String userList(Model model) {
        model.addAttribute("users", users);
        return "userList";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestParam String name,@RequestParam String email) {
        Long id = (long) (users.size() + 1);
        User user = new User(name,email);
        users.add(user);
        return "redirect:/user";
    }

}
