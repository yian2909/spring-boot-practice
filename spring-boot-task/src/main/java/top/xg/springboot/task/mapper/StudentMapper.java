package top.xg.springboot.task.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.xg.springboot.task.entity.Student;

/**
 * @author Lenovo
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {
}
