package top.xg.springboot.database.mapper;

import io.lettuce.core.dynamic.annotation.Param;
import top.xg.springboot.database.entity.Student;

import java.util.List;

/**
 * @author Lenovo
 */
public interface StudentMapper {
    int insert(Student student);
    Student findStudentById(int studentId);
    int updateById(Student student);
    int deleteById(int studentId);
    int batchInsert(@Param("students") List<Student> students);
    int batchDelete(@Param("idList") List<Integer> ids);
    int batchUpdate(@Param("students") List<Student> students);
    List<Student> selectByDynamicSql(Student student);
    Student getStudentManyToOne(int studentId);
    Student getStudent(int studentId);
}
