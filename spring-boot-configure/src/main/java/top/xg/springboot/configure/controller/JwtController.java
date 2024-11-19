<<<<<<< HEAD
package top.xg.springboot.configure.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.xg.springboot.configure.util.JwtUtil;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/jwt")
public class JwtController {
    @Resource
    private JwtUtil jwtUtil;

    @PostMapping("/generate")
    public Map<String,String> generateToken(@RequestParam String username){
        Map<String,Object> claims = new HashMap<>();
        claims.put("username",username);
        String token = jwtUtil.generateToken(claims);
        Map<String,String> response = new HashMap<>();
        response.put("token",token);
        return response;
    }
}
=======
package top.xg.springboot.configure.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.xg.springboot.configure.util.JwtUtil;

import java.util.HashMap;
import java.util.Map;

>>>>>>> 3a445c108c2cb986de68ce29000d3e6bf4ca24b3
