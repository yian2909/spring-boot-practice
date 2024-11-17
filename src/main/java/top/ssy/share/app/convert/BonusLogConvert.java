package top.ssy.share.app.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import top.ssy.share.app.model.entity.BonusLog;
import top.ssy.share.app.model.vo.BonusLogVO;

import java.util.List;

/**
 * @author Lenovo
 */
@Mapper
public interface BonusLogConvert {
    BonusLogConvert INSTANCE = Mappers.getMapper(BonusLogConvert.class);

    List<BonusLogVO> convert(List<BonusLog> list);
}
