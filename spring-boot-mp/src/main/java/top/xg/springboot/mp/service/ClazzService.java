package top.xg.springboot.mp.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import top.xg.springboot.mp.entity.Clazz;
import top.xg.springboot.mp.entity.Student;
import top.xg.springboot.mp.entity.Teacher;
import top.xg.springboot.mp.mapper.ClazzMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lenovo
 */
@Service
@AllArgsConstructor
public class ClazzService {
    private final ClazzMapper clazzMapper;

    public Clazz getClazzWithTeacher(Long clazzId) {
        Clazz clazz = clazzMapper.selectById(clazzId);
        if (clazz != null) {
            Teacher teacher = clazzMapper.selectTeacherByClazzId(clazz.getTeacherId());
            clazz.setTeacher(teacher);
        }
        return clazz;
    }

    public Clazz getClazzWithStudent(Long clazzId) {
        Clazz clazz = clazzMapper.selectById(clazzId);
        if (clazz != null) {
            List<Student> students = clazzMapper.selectStudentByClazzId(clazzId);
            clazz.setStudents(students);
        }
        return clazz;
    }
}
