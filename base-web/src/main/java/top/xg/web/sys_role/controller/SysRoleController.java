package top.xg.web.sys_role.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import top.xg.reshult.ResultVo;
import top.xg.utils.ResultUtils;
import top.xg.web.sys_role.entity.RoleParm;
import top.xg.web.sys_role.entity.SysRole;
import top.xg.web.sys_role.service.SysRoleService;

/**
 * @author Lenovo
 */
@RequestMapping("/api/role")
@RestController
@AllArgsConstructor
public class SysRoleController {
    private final SysRoleService sysRoleService;

    @PostMapping
    @Operation(summary = "新增角色")
    public ResultVo<?> add(@RequestBody SysRole sysRole) {
        if (sysRoleService.save(sysRole)) {
            return ResultUtils.success("新增成功!");
        }
        return ResultUtils.success("新增失败!");
    }

    @PutMapping
    @Operation(summary = "编辑角色")
    public ResultVo<?> edit(@RequestBody SysRole sysRole) {
        if (sysRoleService.updateById(sysRole)) {
            return ResultUtils.success("编辑成功!");
        }
        return ResultUtils.success("编辑失败!");
    }

    @DeleteMapping("/{roleId}")
    @Operation(summary = "删除角色")
    public ResultVo<?> delete(@PathVariable Long roleId) {
        if (sysRoleService.removeById(roleId)) {
            return ResultUtils.success("删除成功!");
        }
        return ResultUtils.success("删除失败!");
    }

    @PostMapping("/getList")
    @Operation(summary = "角色列表")
    public ResultVo<?> getList(@RequestBody RoleParm parm) {
        //构造分⻚对象
        IPage<SysRole> page=new Page<>(parm.getCurrentPage(),parm.getPageSize());
        //构造查询条件
        QueryWrapper<SysRole> query=new QueryWrapper<>();
        if(StringUtils.isNotEmpty(parm.getRoleName())){
            query.lambda().like(SysRole::getRoleName,parm.getRoleName());
        }
        IPage<SysRole> list = sysRoleService.page(page,query);
        return ResultUtils.success("查询成功",list);
    }
}
