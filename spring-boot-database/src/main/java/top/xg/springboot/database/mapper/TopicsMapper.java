package top.xg.springboot.database.mapper;

import top.xg.springboot.database.entity.Topics;

import java.util.List;

public interface TopicsMapper {
    List<Topics> findAll();
}
