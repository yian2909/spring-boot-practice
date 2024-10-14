package top.xg.springboot.database.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author gx
 */
@Data
@AllArgsConstructor
@Builder
public class ResponseResult {
    private  Integer code;
    private String msg;
    private Object data;
}
