package top.ssy.share.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.ssy.share.app.convert.TagConvert;
import top.ssy.share.app.mapper.TagMapper;
import top.ssy.share.app.model.entity.Tag;
import top.ssy.share.app.model.vo.TagVO;
import top.ssy.share.app.service.TagService;

import java.util.List;

/**
 * @author Lenovo
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {
    @Override
    public List<TagVO> getTagList() {
        return TagConvert.INSTANCE.convert(list());
    }
}
