package top.ssy.share.app.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import top.ssy.share.app.model.entity.User;

/**
 * @author Lenovo
 */

public interface UserMapper extends BaseMapper<User> {
    default User getByPhone(String phone){
        return this.selectOne(new LambdaQueryWrapper<User>().eq(User::getPhone,phone));
    }

    default User getByWxOpenId(String openId){
        return this.selectOne(new LambdaQueryWrapper<User>().eq(User::getWxOpenId,openId));
    }
}
