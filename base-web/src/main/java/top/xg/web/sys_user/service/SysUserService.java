package top.xg.web.sys_user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.xg.web.sys_user.entity.SysUser;

/**
 * @author Lenovo
 */
public interface SysUserService extends IService<SysUser> {
    void saveUser(SysUser sysUser);
    void editUser(SysUser sysUser);
    void deleteUser(Long userId);
}
