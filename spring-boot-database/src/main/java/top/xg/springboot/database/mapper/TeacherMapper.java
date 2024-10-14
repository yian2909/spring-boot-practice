package top.xg.springboot.database.mapper;

import top.xg.springboot.database.entity.Teacher;

public interface TeacherMapper {
    Teacher findTeacherById(int teacherId);
}
