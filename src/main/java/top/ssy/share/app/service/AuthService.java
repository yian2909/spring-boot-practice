package top.ssy.share.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.ssy.share.app.model.dto.WxLoginDTO;
import top.ssy.share.app.model.entity.User;
import top.ssy.share.app.model.vo.UserLoginVO;

/**
 * @author Lenovo
 */
public interface AuthService extends IService<User> {
    UserLoginVO loginByPhone(String phone, String code);
    UserLoginVO weChatLogin(WxLoginDTO loginDTO);
    boolean checkUserEnabled(Integer userId);
    void logout();
    void bindPhone(String phone,String code,String accessToken);
}
