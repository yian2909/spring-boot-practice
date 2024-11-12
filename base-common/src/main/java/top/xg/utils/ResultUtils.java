package top.xg.utils;

import top.xg.reshult.ResultVo;
import top.xg.reshult.StatusCode;

/**
 * @author Lenovo
 */
public class ResultUtils {
    /**
     * 无参数返回
     *
     * @return ResultVo
     */
    public static ResultVo<?> success() {
        return vo(null, StatusCode.SUCCESS_CODE, null);
    }

    public static ResultVo<?> success(String msg) {
        return vo(msg, StatusCode.SUCCESS_CODE, null);
    }

    /**
     * 返回带参数
     *
     * @param msg  消息
     * @param data 数据
     * @return ResultVo
     */
    public static ResultVo<?> success(String msg, Object data) {
        return vo(msg, StatusCode.SUCCESS_CODE, data);
    }

    public static ResultVo<?> success(String msg, int code, Object data) {
        return vo(msg, code, data);
    }

    public static ResultVo<?> vo(String msg, int code, Object data) {
        return new ResultVo<>(msg, code, data);
    }

    /**
     * 错误返回
     *
     * @return ResultVo
     */
    public static ResultVo<?> error() {
        return vo(null, StatusCode.ERROR_CODE, null);
    }

    public static ResultVo<?> error(String msg) {
        return vo(msg, StatusCode.ERROR_CODE, null);
    }

    public static ResultVo<?> error(String msg, int code, Object data) {
        return vo(msg, code, data);
    }

    public static ResultVo<?> error(String msg, int code) {
        return vo(msg, code, null);
    }

    public static ResultVo<?> error(String msg, Object data) {
        return vo(msg, StatusCode.ERROR_CODE, data);
    }
}
