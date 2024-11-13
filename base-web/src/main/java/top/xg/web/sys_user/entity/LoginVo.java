package top.xg.web.sys_user.entity;

import lombok.Data;

/**
 * @author Lenovo
 */
@Data
public class LoginVo {
    private Long userId;
    private String nickName;
    private String token;
}
