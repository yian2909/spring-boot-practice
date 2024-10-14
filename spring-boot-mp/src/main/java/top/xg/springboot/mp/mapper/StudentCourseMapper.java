package top.xg.springboot.mp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import top.xg.springboot.mp.entity.Course;
import top.xg.springboot.mp.entity.StudentCourse;

import java.util.List;

/**
 * @author Lenovo
 */
public interface StudentCourseMapper extends BaseMapper<StudentCourse> {
    @Select("SELECT c.* FROM course c INNER JOIN student_course sc ON c.id = sc.course_id WHERE sc.student_id = #{studentId}")
    List<Course> selectCourseByStudentId(Long studentId);
}
