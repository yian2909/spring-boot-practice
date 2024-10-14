package top.xg.springboot.database.mapper;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.xg.springboot.database.entity.Course;
import top.xg.springboot.database.entity.Student;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class CourseMapperTest {
    @Resource
    private CourseMapper courseMapper;
    @Test
    void selectCourse() {
        Course course = courseMapper.selectCourse(20001);
        log.info("课程信息:{},{}",course.getCourseId(),course.getCourseName());
        log.info("选修该课程的学生信息:");
        List<Student> students = course.getStudents();
        students.forEach(student -> log.info("{},{},{},{}",student.getStudentId(),student.getStudentName(),student.getHometown(),student.getBirthday()));
    }
}