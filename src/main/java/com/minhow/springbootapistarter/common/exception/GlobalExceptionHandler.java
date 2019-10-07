package com.minhow.springbootapistarter.common.exception;

import com.minhow.springbootapistarter.common.enums.ResultEnum;
import com.minhow.springbootapistarter.common.response.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

/**
 * 统一异常处理
 * @author MinHow
 * @date 2019/4/3 11:09 上午
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 默认异常
     */
    @ExceptionHandler(Exception.class)
    public Result exception(Exception exception) {
        log.error("exception:", exception);
        return Result.fail(ResultEnum.SYSTEM_EXCEPTION.getCode(), ResultEnum.SYSTEM_EXCEPTION.getMsg());
    }

    /**
     * 请求方法不支持异常
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Result httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException exception) {
        log.error("HttpRequestMethodNotSupportedException:", exception);
        return Result.fail(ResultEnum.FAILURE.getCode(), ResultEnum.FAILURE.getMsg());
    }

    /**
     * 请求参数异常
     */
    @ExceptionHandler({HttpMessageNotReadableException.class, MissingServletRequestParameterException.class, MissingServletRequestPartException.class, BindException.class})
    public Result parameterException() {
        return Result.fail(ResultEnum.PARAMETER_ERROR.getCode(), ResultEnum.PARAMETER_ERROR.getMsg());
    }

    /**
     * 默认异常
     */
    @ExceptionHandler(AbstractException.class)
    public Result abstractException(AbstractException exception) {
        log.error("AbstractException:", exception);
        return Result.fail(exception.getCode(), exception.getMsg());
    }
}
