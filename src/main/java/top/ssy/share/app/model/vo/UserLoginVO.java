package top.ssy.share.app.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author Lenovo
 */
@Data
@Schema(description = "用户登录vo")
public class UserLoginVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 4111857890940510726L;
    @Schema(description="用户ID")
    private Integer pkId;
    @Schema(description="手机号")
    private String phone;
    @Schema(description="微信OpenId")
    private String wxOpenId;
    @Schema(description="令牌")
    private String accessToken;
}
