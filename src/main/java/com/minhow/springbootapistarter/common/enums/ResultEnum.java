package com.minhow.springbootapistarter.common.enums;

import lombok.Getter;

/**
 * 返回结果
 * @author MinHow
 * @date 2019/10/3 3:44 下午
 */
@Getter
public enum ResultEnum {
    SUCCESS(200, "SUCCESS"),

    TOKEN_ERROR(1001, "会话已过期，请重新登录"),

    FAILURE(3000, "出错了，请联系管理员！"),

    SYSTEM_EXCEPTION(5000,"系统出错了！"),

    PARAMETER_ERROR(3001, "参数校验失败"),

    BUSINESS_ERROR(4001, "业务处理失败");

    private Integer code;
    private String msg;

    ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
