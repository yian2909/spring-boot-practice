package top.ssy.share.app.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import top.ssy.share.app.enums.UserActionEnum;
import top.ssy.share.app.model.entity.UserAction;
import top.ssy.share.app.model.vo.UserActionListInfo;

/**
 * @author Lenovo
 */
public interface UserActionService extends IService<UserAction> {
    void insertUserAction(Integer userId, Integer resourceId, UserActionEnum userActionEnum);

    void collectResource(Integer resourceId);

    void likeResource(Integer resourceId);

    void exchangeResource(Integer resourceId);

    UserActionListInfo selectResourceListByUserIdAndType(Integer userId, UserActionEnum userActionEnum, Page<UserAction> page);

    Integer selectCountByResourceIdAndType(Integer resourceId,UserActionEnum userActionEnum);

    Boolean resourceIsAction(Integer userId,Integer resourceId,UserActionEnum userActionEnum);
}
