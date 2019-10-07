package com.minhow.springbootapistarter.common.exception;


import com.minhow.springbootapistarter.common.enums.ResultEnum;

/**
 *  业务异常
 * @author MinHow
 * @date 2019/4/3 11:09 上午
 */
public class BusinessException extends AbstractException {
    protected BusinessException(ResultEnum restEnum, Exception e) {
        super(restEnum, e);
    }

    public BusinessException(ResultEnum restEnum) {
        super(restEnum);
    }
}
