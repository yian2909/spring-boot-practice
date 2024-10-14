package top.xg.springboot.mp.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.xg.springboot.mp.entity.Student;
import top.xg.springboot.mp.service.StudentService;

/**
 * @author Lenovo
 */
@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/{id}/course")
    public Student getStudentWithCourse(@PathVariable Long id) {
        return studentService.getStudentWithCourse(id);
    }
}
