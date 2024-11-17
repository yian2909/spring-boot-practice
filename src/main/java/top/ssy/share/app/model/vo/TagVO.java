package top.ssy.share.app.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author Lenovo
 */
@Data
@Schema(name = "标签返回vo")
public class TagVO {
    @Schema(name="pkId",description="主键")
    private Integer pkId;
    @Schema(name="title",description="标题")
    private String title;
    @Schema(name="isHot",description="是否热⻔")
    private Integer isHot;
}
