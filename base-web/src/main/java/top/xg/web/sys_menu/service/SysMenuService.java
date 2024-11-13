package top.xg.web.sys_menu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.xg.web.sys_menu.entity.SysMenu;

import java.util.List;

/**
 * @author Lenovo
 */
public interface SysMenuService extends IService<SysMenu> {
    List<SysMenu> getParent();
    //根据用户id查询菜单
    List<SysMenu> getMenuByUserId(Long userId);
    //根据⻆色id查询菜单
    List<SysMenu> getMenuByRoleId(Long roleId);
}
