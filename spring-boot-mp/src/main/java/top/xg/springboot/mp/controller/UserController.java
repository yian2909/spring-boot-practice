package top.xg.springboot.mp.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import top.xg.springboot.mp.entity.User;
import top.xg.springboot.mp.service.UserService;

import java.util.List;

/**
 * @author Lenovo
 */
@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("create")
    public String createUser(@RequestBody User user) {
        boolean result = userService.createUser(user);
        return result ? "用户创建成功" : "用户创建失败";
    }

    @PutMapping("/update")
    public String updateUser(@RequestBody User user) {
        boolean result = userService.updateUser(user);
        return result ? "用户更新成功" : "用户更新失败";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        boolean result = userService.deleteUserById(id);
        return result ? "用户删除成功" : "用户删除失败";
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/name")
    public List<User> getUserByUserName(@RequestParam String name) {
        return userService.getAllUserByName(name);
    }

    @GetMapping("/page")
    public Page<User> getUserByPage(@RequestParam int currentPage, @RequestParam int pageSize) {
       return userService.getUserByPage(currentPage, pageSize);
    }
}
