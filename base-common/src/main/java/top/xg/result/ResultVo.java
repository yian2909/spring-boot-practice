package top.xg.result;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Lenovo
 */
@Data
@AllArgsConstructor
public class ResultVo<T> {
    private String msg;
    private int code;
    private T data;
}
