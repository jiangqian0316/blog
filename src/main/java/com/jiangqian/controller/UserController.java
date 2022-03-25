package com.jiangqian.controller;


import com.jiangqian.common.lang.Result;
import com.jiangqian.entity.User;
import com.jiangqian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
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

        @GetMapping("/{id}")
        public Result test(@PathVariable("id") Long id) {
            User byId = userService.getById(id);
            return Result.succ(200,"操作成功",byId);

    }
}
