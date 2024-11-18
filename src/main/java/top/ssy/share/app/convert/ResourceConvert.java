package top.ssy.share.app.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import top.ssy.share.app.model.dto.ResourcePublishDTO;
import top.ssy.share.app.model.entity.Resource;

/**
 * @author Lenovo
 */
@Mapper
public interface ResourceConvert {
    ResourceConvert INSTANCE = Mappers.getMapper(ResourceConvert.class);
    Resource convert(ResourcePublishDTO dto);
}
