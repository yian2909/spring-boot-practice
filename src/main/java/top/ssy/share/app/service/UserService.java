package top.ssy.share.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.ssy.share.app.model.dto.UserEditDTO;
import top.ssy.share.app.model.entity.User;
import top.ssy.share.app.model.vo.UserInfoVO;

/**
 * @author Lenovo
 */
public interface UserService extends IService<User> {
    UserInfoVO userInfo();
    UserInfoVO updateInfo(UserEditDTO userEditDTO);
}
