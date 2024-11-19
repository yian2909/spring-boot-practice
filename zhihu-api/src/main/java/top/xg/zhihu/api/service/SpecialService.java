package top.xg.zhihu.api.service;

import top.xg.zhihu.api.entity.Special;

import java.util.List;

/**
 * @author gx
 */
public interface SpecialService {
    List<Special> getAll();
    List<Special> getByPage(int limit,int offset);
}
