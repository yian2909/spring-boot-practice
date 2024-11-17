package top.ssy.share.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.ssy.share.app.convert.CategoryConvert;
import top.ssy.share.app.mapper.CategoryMapper;
import top.ssy.share.app.model.entity.Category;
import top.ssy.share.app.model.vo.CategoryVO;
import top.ssy.share.app.service.CategoryService;

import java.util.List;

/**
 * @author Lenovo
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Override
    public List<CategoryVO> getCategoryList() {
        LambdaQueryWrapper<Category> wrapper = new LambdaQueryWrapper<>();
        return CategoryConvert.INSTANCE.convert(list(wrapper));
    }
}
