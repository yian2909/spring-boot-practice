package top.ssy.share.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.ssy.share.app.model.entity.Category;
import top.ssy.share.app.model.vo.CategoryVO;

import java.util.List;

/**
 * @author Lenovo
 */
public interface CategoryService extends IService<Category> {
    List<CategoryVO> getCategoryList();
}
