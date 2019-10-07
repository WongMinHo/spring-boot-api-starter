package com.minhow.springbootapistarter.common.exception;

import com.minhow.springbootapistarter.common.enums.ResultEnum;

/**
 * token 异常
 * @author MinHow
 * @date 2019/10/6 10:19 上午
 */
public class TokenException extends AbstractException {
    public TokenException() {
        super(ResultEnum.TOKEN_ERROR.getCode(), ResultEnum.TOKEN_ERROR.getMsg());
    }
}
