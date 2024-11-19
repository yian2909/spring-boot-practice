<<<<<<< HEAD
package top.xg.springboot.configure.mapper;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.xg.springboot.configure.entity.Special;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SpecialMapperTest {
    @Resource
    private SpecialMapper specialMapper;
    @Test
    void findAll() {
        List<Special> specials = specialMapper.findAll();
        specials.forEach(System.out::println);
    }
=======
package top.xg.springboot.configure.mapper;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.xg.springboot.configure.entity.Special;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SpecialMapperTest {
    @Resource
    private SpecialMapper specialMapper;
    @Test
    void findAll() {
        List<Special> specials = specialMapper.findAll();
        specials.forEach(System.out::println);
    }
>>>>>>> 3a445c108c2cb986de68ce29000d3e6bf4ca24b3
}