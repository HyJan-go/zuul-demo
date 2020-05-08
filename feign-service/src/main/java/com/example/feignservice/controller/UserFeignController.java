package com.example.feignservice.controller;

import com.example.feignservice.domain.CommonResult;
import com.example.feignservice.domain.User;
import com.example.feignservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: demo
 * @description: 用户控制类
 * @author: HyJan
 * @create: 2020-05-06 14:29
 **/
@RestController
@RequestMapping("/user")
@Slf4j
public class UserFeignController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public CommonResult createUser(@RequestBody User user) {
        userService.create(user);
        return new CommonResult(200, "操作成功");
    }

    @GetMapping("/{id}")
    public CommonResult getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @GetMapping("/getByUsername")
    public CommonResult getUserByName(@RequestParam String username) {
        return userService.getByUsername(username);
    }

    @PostMapping("/update")
    public CommonResult updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @PostMapping("/delete/{id}")
    public CommonResult deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }
}
