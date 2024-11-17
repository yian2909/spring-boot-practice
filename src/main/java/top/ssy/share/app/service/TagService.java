package top.ssy.share.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.ssy.share.app.model.entity.Tag;
import top.ssy.share.app.model.vo.TagVO;

import java.util.List;

/**
 * @author Lenovo
 */
public interface TagService extends IService<Tag> {
    List<TagVO> getTagList();
}
