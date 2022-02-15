package com.pxd.common.base.handler;

import cn.hutool.core.exceptions.ExceptionUtil;
import com.pxd.common.result.enums.ErrorCodeEnum;
import com.pxd.common.result.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice
public class PxdExceptionHandler {

    @ExceptionHandler({IllegalArgumentException.class, IllegalStateException.class})
    public Result<?> handleIllegalArgumentException(RuntimeException exception) {
        return Result.error(ErrorCodeEnum.PARAM_ERROR.getCode(), exception.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result<?> exceptionHandler(HttpServletRequest request, Exception exception) {
        exception.printStackTrace();
        return Result.error(exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        return Result.error(exception.getBindingResult().getFieldError().getDefaultMessage());
    }

}
