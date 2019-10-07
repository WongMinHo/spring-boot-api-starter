package com.minhow.springbootapistarter.service.second;

import com.minhow.springbootapistarter.common.response.Result;
import com.minhow.springbootapistarter.pojo.dto.StoreCustomerDTO;
import com.minhow.springbootapistarter.pojo.entity.second.Customer;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author MinHow
 * @since 2019-10-05
 */
public interface CustomerService extends IService<Customer> {
    /**
     * 新增客户 - 演示多数据源分布式事务
     * @param storeCustomerDTO
     * @return
     */
    Result store(StoreCustomerDTO storeCustomerDTO);
}
