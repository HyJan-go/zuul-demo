package com.example.feignservice.service.impl;

import com.example.feignservice.domain.CommonResult;
import com.example.feignservice.domain.User;
import com.example.feignservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @program: demo
 * @description: 当feign请求出错的时候，回调函数方法就是实现类的方法
 * @author: HyJan
 * @create: 2020-05-07 19:04
 **/
@Component
@Slf4j
public class UserFallbackService implements UserService {

    @Override
    public CommonResult create(User user) {
        User defaultUser = new User(15845L,"defaultUser","123456");
        return new CommonResult(defaultUser);
    }

    @Override
    public CommonResult getUser(Long id) {
        log.info("调用失败");
        User defaultUser = new User(15845L,"defaultUser","123456");
        return new CommonResult(defaultUser);
    }

    @Override
    public CommonResult updateUser(User user) {
       return new CommonResult(500, "调用服务失败");
    }

    @Override
    public CommonResult deleteUser(Long id) {
        return new CommonResult(500,"调用失败，服务被降级");
    }

    @Override
    public CommonResult getByUsername(String username) {
        User defaultUser = new User(15845L,"defaultUser","123456");
        return new CommonResult(defaultUser);
    }
}
