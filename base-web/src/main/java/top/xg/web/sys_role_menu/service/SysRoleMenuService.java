package top.xg.web.sys_role_menu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.xg.web.sys_role_menu.entity.SysRoleMenu;
import top.xg.web.sys_role_menu.entity.SaveMenuParm;

/**
 * @author Lenovo
 */
public interface SysRoleMenuService extends IService<SysRoleMenu> {
    void saveRoleMenu(SaveMenuParm parm);
}
