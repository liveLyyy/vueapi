package com.liyan.vueapi.test;

import com.liyan.vueapi.pojo.Role;
import com.liyan.vueapi.service.Impl.RoleServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Roletest {
    @Autowired
    RoleServiceImpl roleService;

    @Test
    public void role(){
        List<Role> roleList=roleService.findAll();
    }
}
