package com.minhow.springbootapistarter.pojo.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author MinHow
 * @date 2019/10/6 11:49 上午
 */
@Data
public class StoreCustomerDTO {
    @NotBlank(message = "客户名不能为空")
    private String customerName;

    @NotBlank(message = "客户手机号不能为空")
    private String customerPhone;

    @NotNull(message = "用户id不能为空")
    private Integer userId;
}
