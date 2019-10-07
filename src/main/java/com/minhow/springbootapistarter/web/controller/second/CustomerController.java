package com.minhow.springbootapistarter.web.controller.second;


import com.minhow.springbootapistarter.common.response.Result;
import com.minhow.springbootapistarter.pojo.dto.StoreCustomerDTO;
import com.minhow.springbootapistarter.service.second.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author MinHow
 * @since 2019-10-05
 */
@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("")
    public Result store(@Valid StoreCustomerDTO storeCustomerDTO) {
        return customerService.store(storeCustomerDTO);
    }
}

