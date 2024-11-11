package top.xg.web.sys_role.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Lenovo
 */
@Data
@TableName("sys_role")
public class SysRole {
    @TableId(type= IdType.AUTO)
    private Long roleId;
    private String roleName;
    private String remark;
    private String type;

    @TableLogic
    private Integer deleted;

    @TableField(fill=FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill=FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
