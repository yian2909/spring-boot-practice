package top.xg.springboot.configure.entity;

import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestBody;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class StudentTest {
    @Resource
    private Student student;
    @Resource
    private Dog dog;
    @Test
    void testStudent() {
        log.info(String.valueOf(dog));
        log.info(String.valueOf(student));
    }
}