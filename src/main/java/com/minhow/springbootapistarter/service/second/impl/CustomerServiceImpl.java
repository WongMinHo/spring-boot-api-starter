package com.minhow.springbootapistarter.service.second.impl;

import com.minhow.springbootapistarter.common.enums.ResultEnum;
import com.minhow.springbootapistarter.common.exception.BusinessException;
import com.minhow.springbootapistarter.common.response.Result;
import com.minhow.springbootapistarter.pojo.dto.StoreCustomerDTO;
import com.minhow.springbootapistarter.pojo.entity.first.User;
import com.minhow.springbootapistarter.pojo.entity.second.Customer;
import com.minhow.springbootapistarter.dao.second.mapper.CustomerMapper;
import com.minhow.springbootapistarter.service.first.UserService;
import com.minhow.springbootapistarter.service.second.CustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author MinHow
 * @since 2019-10-05
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {
    @Autowired
    private UserService userService;
    /**
     * 新增客户 - 演示多数据源分布式事务
     * @param storeCustomerDTO
     * @return
     */
    @Override
    @Transactional(rollbackFor = BusinessException.class)
    public Result store(StoreCustomerDTO storeCustomerDTO) {
        User user = userService.lambdaQuery()
                .select(User::getId, User::getCustomerNum)
                .eq(User::getId, storeCustomerDTO.getUserId())
                .one();

        if (user == null) {
            return Result.fail(4001, "用户不存在");
        }

        Customer customer = new Customer();
        customer.setName(storeCustomerDTO.getCustomerName())
                .setPhone(storeCustomerDTO.getCustomerPhone())
                .setUserId(storeCustomerDTO.getUserId());
        //添加客户
        boolean customerStatus = this.save(customer);

        //更新用户客户数
        boolean userStatus = userService.lambdaUpdate()
                .set(User::getCustomerNum, user.getCustomerNum() + 1)
                .eq(User::getId, storeCustomerDTO.getUserId())
                .update();
        //不符合条件，两个数据库表数据回滚
        if (! customerStatus || ! userStatus) {
            throw new BusinessException(ResultEnum.BUSINESS_ERROR);
        }

        return Result.ok();
    }
}
