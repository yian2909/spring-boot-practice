package top.xg.web.sys_user.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.xg.web.sys_user.entity.SysUser;
import top.xg.web.sys_user.mapper.SysUserMapper;
import top.xg.web.sys_user.service.SysUserService;

/**
 * @author Lenovo
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
}
