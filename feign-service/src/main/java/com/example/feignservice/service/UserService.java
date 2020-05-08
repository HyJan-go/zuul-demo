package com.example.feignservice.service;

import com.example.feignservice.domain.CommonResult;
import com.example.feignservice.domain.User;
import com.example.feignservice.service.impl.UserFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @program: demo
 * @description: 用户服务类
 * FeignClient 的fallback，如果是当前类的实现类，则实现方法就是回调方法，也可以传入一个方法名，此时出错就是
 * 调用指定的方法
 * @author: HyJan
 * @create: 2020-05-06 12:01
 **/
@FeignClient(value = "user-service", fallback = UserFallbackService.class)
public interface UserService {

    /**
     * 创建用户信息
     *
     * @param user
     * @return
     */
    @PostMapping("/user/create")
    CommonResult create(@RequestBody User user);

    /**
     * 通过id获取用户信息
     *
     * @param id
     * @return
     */
    @GetMapping("/user/{id}")
    CommonResult getUser(@PathVariable Long id);

    /**
     * 更新用户信息
     *
     * @param user
     */
    @PostMapping("/user/update")
    CommonResult updateUser(@RequestBody User user);

    /**
     * 删除用户信息
     *
     * @param id
     */
    @PostMapping("/user/delete/{id}")
    CommonResult deleteUser(@PathVariable Long id);

    /**
     * 通过用户名获取用户信息
     *
     * @param username
     * @return
     */
    @GetMapping("/user/getByUsername")
    CommonResult getByUsername(@RequestParam String username);
}
