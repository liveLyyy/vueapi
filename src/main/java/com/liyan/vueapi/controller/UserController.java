package com.liyan.vueapi.controller;


import com.github.pagehelper.PageInfo;
import com.liyan.vueapi.enums.ResultCode;
import com.liyan.vueapi.pojo.User;
import com.liyan.vueapi.result.Result;
import com.liyan.vueapi.service.Impl.RoleServiceImpl;
import com.liyan.vueapi.service.Impl.UserServiceImpl;
import com.liyan.vueapi.util.RedisUtils;
import com.liyan.vueapi.util.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    RoleServiceImpl roleService;
    @Autowired
    private RedisUtils redisUtils;


    @PostMapping("/user/login")
    public Result login(@RequestBody User user, HttpServletRequest request) {
        String username = user.getUsername();
        username = HtmlUtils.htmlEscape(username);
        User list = userService.Login(username, user.getPassword());
        if (list != null) {
            redisUtils.set("loginUser",String.valueOf(list.getId()));
            return Result.success(list);
        } else {
            return Result.failure(ResultCode.DATA_IS_WRONG);
        }
    }


    @GetMapping("/user/users")
    public Result pageList(Integer pageCount, Integer pageSize, HttpServletRequest request) throws Exception {
        PageInfo<User> pageInfo = userService.findByPage(pageCount, pageSize, request.getParameter("username"), request.getParameter("phone"), request.getParameter("email"));
        if (pageInfo != null) {
            return Result.success(pageInfo);
        } else {
            return Result.failure(ResultCode.DATA_IS_WRONG);
        }
    }


    @PostMapping("/user/addUsers")
    public Result addUser(@RequestBody User user) throws Exception {
        String username = user.getUsername();
        String password = user.getPassword();
        String phone = user.getPhone();
        String email = user.getEmail();
        String token = TokenUtils.getToken(user.getPassword());
        int index = userService.addUser(username, password, phone, email);
        if (index != 0) {
            return Result.success();
        } else {
            return Result.failure(ResultCode.DATA_IS_WRONG);
        }
    }


    @GetMapping("/user/findById/{id}")
    public Result findById(@PathVariable Integer id) {
        User user1 = userService.findById(id);
        if (user1 != null) {
            return Result.success(user1);
        } else {
            return Result.failure(ResultCode.DATA_IS_WRONG);
        }
    }


    @PutMapping("/user/updateUser/{id}")
    public Result updateUser(@RequestBody User user, @PathVariable Integer id) {
        String phone = user.getPhone();
        String email = user.getEmail();
        int index = userService.updateUser(id, phone, email);
        if (index != 0) {
            return Result.success(index);
        } else {
            return Result.failure(ResultCode.DATA_IS_WRONG);
        }
    }


    @DeleteMapping("/user/deleteByIdUser/{id}")
    public Result deleteUser(@PathVariable Integer id) {
        int index = userService.deleteByIdUser(id);
        if (index != 0) {
            return Result.success(index);
        } else {
            return Result.failure(ResultCode.DATA_IS_WRONG);
        }
    }
}
