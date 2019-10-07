package com.minhow.springbootapistarter.pojo.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author MinHow
 * @date 2019/10/6 10:49 上午
 */
@Data
public class LoginDTO {
    @NotBlank(message = "用户名不能为空")
    private String name;

    @NotBlank(message = "密码不能为空")
    private String password;
}
