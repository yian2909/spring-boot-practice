package top.xg.springboot.mp.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.xg.springboot.mp.entity.Clazz;
import top.xg.springboot.mp.service.ClazzService;

/**
 * @author Lenovo
 */
@RestController
@RequestMapping("/clazz")
@AllArgsConstructor
public class ClazzController {
    private final ClazzService clazzService;

    @GetMapping("/{id}/teacher")
    public Clazz getClazzWithTeacher(@PathVariable Long id) {
        return clazzService.getClazzWithTeacher(id);
    }

    @GetMapping("/{id}/student")
    public Clazz getClazzWithStudent(@PathVariable Long id) {
        return clazzService.getClazzWithStudent(id);
    }
}
