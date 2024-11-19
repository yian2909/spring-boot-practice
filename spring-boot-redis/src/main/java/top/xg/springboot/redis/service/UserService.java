package top.xg.springboot.redis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.xg.springboot.redis.entity.User;
import top.xg.springboot.redis.vo.UserInfoVO;
import top.xg.springboot.redis.vo.UserLoginVO;

public interface UserService extends IService<User> {
    UserLoginVO loginByPhone(String phone,String code);

    boolean checkUserEnable(Long userId);

    UserInfoVO userInfo(Long userId);
}
