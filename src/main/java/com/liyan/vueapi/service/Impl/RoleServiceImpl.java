package com.liyan.vueapi.service.Impl;

import com.liyan.vueapi.mapper.RoleMapper;
import com.liyan.vueapi.pojo.Role;
import com.liyan.vueapi.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleMapper roleMapper;

    @Override
    public List<Role> findAll() {
        return roleMapper.findAll();
    }
}
