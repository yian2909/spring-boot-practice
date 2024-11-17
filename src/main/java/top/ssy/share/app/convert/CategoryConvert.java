package top.ssy.share.app.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import top.ssy.share.app.model.entity.Category;
import top.ssy.share.app.model.vo.CategoryVO;

import java.util.List;

/**
 * @author Lenovo
 */
@Mapper
public interface CategoryConvert {
    CategoryConvert INSTANCE = Mappers.getMapper(CategoryConvert.class);
    List<CategoryVO> convert(List<Category> list);
}
