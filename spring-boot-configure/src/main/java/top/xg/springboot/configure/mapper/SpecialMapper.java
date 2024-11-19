<<<<<<< HEAD
package top.xg.springboot.configure.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.xg.springboot.configure.entity.Special;

import java.util.List;

@Mapper
public interface SpecialMapper {
    @Select("SELECT * FROM list ORDER BY updated DESC ")
    List<Special> findAll();
}
=======
package top.xg.springboot.configure.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.xg.springboot.configure.entity.Special;

import java.util.List;

@Mapper
public interface SpecialMapper {
    @Select("SELECT * FROM list ORDER BY updated DESC ")
    List<Special> findAll();
}
>>>>>>> 3a445c108c2cb986de68ce29000d3e6bf4ca24b3
