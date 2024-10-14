package top.xg.springboot.mp.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.List;

/**
 * @author Lenovo
 */
@Data
public class Student {
    private Long id;
    private String name;
    private Long clazzId;

    //用于一对多映射
    @TableField(exist = false)
    private List<Course> course;
}
