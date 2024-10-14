package top.xg.springboot.mp.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import top.xg.springboot.mp.entity.Course;
import top.xg.springboot.mp.entity.Student;
import top.xg.springboot.mp.mapper.StudentCourseMapper;
import top.xg.springboot.mp.mapper.StudentMapper;

import java.util.List;

/**
 * @author Lenovo
 */
@Service
@AllArgsConstructor
public class StudentService {
    private final StudentMapper studentMapper;
    private final StudentCourseMapper studentCourseMapper;

    public Student getStudentWithCourse(Long studentId){
        Student student = studentMapper.selectById(studentId);
        if (student != null){
            List<Course> courses = studentCourseMapper.selectCourseByStudentId(studentId);
            student.setCourse(courses);
        }
        return student;
    }
}
