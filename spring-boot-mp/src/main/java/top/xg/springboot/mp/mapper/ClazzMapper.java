package top.xg.springboot.mp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import top.xg.springboot.mp.entity.Clazz;
import top.xg.springboot.mp.entity.Student;
import top.xg.springboot.mp.entity.Teacher;

import java.util.List;

/**
 * @author Lenovo
 */
public interface ClazzMapper extends BaseMapper<Clazz> {
    @Select("SELECT * FROM teacher WHERE id = #{teacherId}")
    Teacher selectTeacherByClazzId(Long teacherId);

    @Select("SELECT * FROM student WHERE clazz_id = #{clazzId}")
    List<Student> selectStudentByClazzId(Long clazzId);
}
