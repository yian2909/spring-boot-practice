package top.xg.web.sys_user.entity;

import lombok.Data;

/**
 * @author Lenovo
 */
@Data
public class UpdatePasswordParm {
    private Long userId;
    private String oldPassword;
    private String password;
}
