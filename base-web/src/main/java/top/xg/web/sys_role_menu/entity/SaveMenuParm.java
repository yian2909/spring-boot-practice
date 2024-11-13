package top.xg.web.sys_role_menu.entity;

import lombok.Data;

import java.util.List;

/**
 * @author Lenovo
 */
@Data
public class SaveMenuParm {
    private Long roleId;
    private List<Long> list;
}
