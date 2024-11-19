package top.xg.zhihu.api.mapper;

import top.xg.zhihu.api.entity.Special;

import java.util.List;

public interface SpecialMapper {
    List<Special> selectAll();
    List<Special> selectByPage(int limit,int offset);
}
