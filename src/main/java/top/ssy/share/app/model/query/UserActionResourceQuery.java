package top.ssy.share.app.model.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Lenovo
 */
@Data
@EqualsAndHashCode(callSuper=true)
@Schema(name = "UserActionResourceQuery", description = "用户行为资源查询")
public class UserActionResourceQuery extends Query{
    @Schema(description="用户行为")
    private Integer type;
}
