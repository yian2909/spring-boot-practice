package top.xg.springboot.database.mapper;

import top.xg.springboot.database.entity.Clazz;

public interface ClazzMapper {
    Clazz getClazzById(int clazzId);
    Clazz getClazz(int clazzId);
}
