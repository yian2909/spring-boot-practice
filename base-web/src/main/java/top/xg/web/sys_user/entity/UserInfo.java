package top.xg.web.sys_user.entity;

import lombok.Data;

/**
 * @author Lenovo
 */
@Data
public class UserInfo {
    private Long userId;
    private String name;
    private Object[] permissions;
}
