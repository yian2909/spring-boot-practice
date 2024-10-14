package top.xg.springboot.database.mapper;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.xg.springboot.database.entity.Teacher;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class TeacherMapperTest {
    @Resource TeacherMapper teacherMapper;
    @Test
    void findTeacherById() {
        Teacher teacher = teacherMapper.findTeacherById(1);
        log.info("{},{}",teacher.getTeacherName(),teacher.getClazz().getClazzName());
    }
}