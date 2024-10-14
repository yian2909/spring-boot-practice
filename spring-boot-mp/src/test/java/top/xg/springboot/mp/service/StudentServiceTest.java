package top.xg.springboot.mp.service;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.xg.springboot.mp.entity.Student;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class StudentServiceTest {
    @Resource
    private StudentService studentService;
    @Test
    void getStudentWithCourse() {
        Student student = studentService.getStudentWithCourse(1L);
        log.info("{},{}",student.getId(),student.getName());
        student.getCourse().forEach(course -> log.info("{},{}",course.getId(),course.getName()));
    }
}