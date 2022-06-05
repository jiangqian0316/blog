package com.jiangqian.controller;


import com.jiangqian.common.lang.Result;
import com.jiangqian.entity.User;
import com.jiangqian.service.UserService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.util.Set;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author JQQ
 * @since 2022-03-25
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequiresAuthentication
    @GetMapping("/{id}")
    public Result test(@PathVariable("id") Long id) {
        User byId = userService.getById(id);
        return Result.succ(200, "操作成功", byId);
    }

    @PostMapping("save")
    public Result save( @Validated @RequestBody User user){
        return Result.succ(user);
    }


}
