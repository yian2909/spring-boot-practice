package top.xg.web.sys_role_menu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import top.xg.web.sys_role_menu.entity.SysRoleMenu;

import java.util.List;

/**
 * @author Lenovo
 */
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu> {
    //保存角色菜单
    boolean saveRoleMenu(@Param("roleId") Long roleId, @Param("menuIds") List<Long> menuIds);
}
