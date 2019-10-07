package com.minhow.springbootapistarter.service.first;

import com.minhow.springbootapistarter.common.response.Result;
import com.minhow.springbootapistarter.pojo.dto.LoginDTO;
import com.minhow.springbootapistarter.pojo.entity.first.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author MinHow
 * @since 2019-10-05
 */
public interface UserService extends IService<User> {
    /**
     * 用户登录
     * @param loginDTO
     * @return
     */
    Result login(LoginDTO loginDTO);
}
