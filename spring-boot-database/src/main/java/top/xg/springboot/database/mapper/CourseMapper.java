package top.xg.springboot.database.mapper;

import top.xg.springboot.database.entity.Course;

/**
 * @author Lenovo
 */
public interface CourseMapper {
    Course selectCourse(Integer id);
}
