package top.ssy.share.app.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Lenovo
 */
@Data
@TableName("t_tag")
public class Tag {
    @TableId(type= IdType.AUTO,value="pk_id")
    private Integer pkId;
    private String title;
    private String description;
    private Integer isHot;
    @TableField(value="delete_flag",fill= FieldFill.INSERT)
    @TableLogic
    private Integer deleteFlag;
    @TableField(value="update_time",fill=FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
    @TableField(value="create_time",fill=FieldFill.INSERT)
    private LocalDateTime createTime;
}
