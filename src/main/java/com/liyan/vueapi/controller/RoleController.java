package com.liyan.vueapi.controller;

import com.liyan.vueapi.enums.ResultCode;
import com.liyan.vueapi.pojo.Role;
import com.liyan.vueapi.result.Result;
import com.liyan.vueapi.service.Impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RoleController {
    @Autowired
    RoleServiceImpl roleService;

    @GetMapping("/sys/role")
    public Result Role(){
        List<Role> roleList=roleService.findAll();
        if (roleList != null){
            return Result.success(roleList);
        }else {
            return Result.failure(ResultCode.FAILURE);
        }
    }
}
