package com.liyan.vueapi.service;

import com.liyan.vueapi.pojo.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {
    List<Role> findAll();
}
