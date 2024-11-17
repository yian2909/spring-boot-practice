package top.ssy.share.app.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import top.ssy.share.app.model.entity.Tag;
import top.ssy.share.app.model.vo.TagVO;

import java.util.List;

/**
 * @author Lenovo
 */
@Mapper
public interface TagConvert {
    TagConvert INSTANCE = Mappers.getMapper(TagConvert.class);
    List<TagVO> convert(List<Tag> tags);
}
