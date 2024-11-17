package top.ssy.share.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.ssy.share.app.common.result.PageResult;
import top.ssy.share.app.enums.BonusActionEnum;
import top.ssy.share.app.model.entity.BonusLog;
import top.ssy.share.app.model.query.Query;
import top.ssy.share.app.model.vo.BonusLogVO;

/**
 * @author Lenovo
 */
public interface BonusLogService extends IService<BonusLog> {
    PageResult<BonusLogVO> page(Query query);

    //增加积分，直接用枚举类中定义的价格
    void addBonusLog(Integer userId, BonusActionEnum contentEnum);

    //增加积分，使用入参进行增减
    void addBonusLog(Integer userId,BonusActionEnum contentEnum,Integer bonus);

    //检查今日是否签到的方法
    void dailyCheck();

    //今日是否签到
    boolean isTodayCheck(Integer userId);

}
