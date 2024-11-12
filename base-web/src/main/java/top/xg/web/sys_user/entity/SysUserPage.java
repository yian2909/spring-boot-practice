package top.xg.web.sys_user.entity;

import lombok.Data;

/**
 * @author Lenovo
 */
@Data
public class SysUserPage {
    private String phone;
    private String nickName;
    private Long currentPage;
    private Long pageSize;
}
