package top.xg.web.sys_role.entity;

import lombok.Data;

/**
 * @author Lenovo
 */
@Data
public class RoleParm {
    private Long currentPage;
    private Long pageSize;
    private String roleName;
}
