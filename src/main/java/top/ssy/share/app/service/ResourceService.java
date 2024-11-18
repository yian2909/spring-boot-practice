package top.ssy.share.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.ssy.share.app.common.result.PageResult;
import top.ssy.share.app.model.dto.ResourcePublishDTO;
import top.ssy.share.app.model.entity.Resource;
import top.ssy.share.app.model.query.ResourceQuery;
import top.ssy.share.app.model.query.UserActionResourceQuery;
import top.ssy.share.app.model.vo.ResourceDetailVO;
import top.ssy.share.app.model.vo.ResourceItemVO;

/**
 * @author Lenovo
 */
public interface ResourceService extends IService<Resource> {
    PageResult<ResourceItemVO> getUserActionResourcePage(UserActionResourceQuery query);

    PageResult<ResourceItemVO> getResourcePage(ResourceQuery query);

    ResourceDetailVO getResourceDetail(Integer resourceId, String accessToken);

    void publish(ResourcePublishDTO dto);
}
