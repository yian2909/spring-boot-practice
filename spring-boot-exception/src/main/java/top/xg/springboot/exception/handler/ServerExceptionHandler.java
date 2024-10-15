package top.xg.springboot.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.xg.springboot.exception.enums.ErrorCode;
import top.xg.springboot.exception.exception.ServerException;
import top.xg.springboot.exception.result.Result;


/**
 * @author Lenovo
 */
@Slf4j
@RestControllerAdvice
public class ServerExceptionHandler {
    @ExceptionHandler(ServerException.class)
    public Result<String> handleException(ServerException e) {
        return Result.error(e.getCode(), e.getMsg());
    }

    @ExceptionHandler(BindException.class)
    public Result<String> bindException(BindException e) {
        FieldError fieldError = e.getFieldError();
        assert fieldError != null;
        return Result.error(fieldError.getDefaultMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result<String> handleException(Exception e) {
        log.error(e.getMessage(), e);
        return Result.error(ErrorCode.INTERNAL_SERVER_ERROR);
    }
}
