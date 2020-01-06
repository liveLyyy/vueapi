package com.liyan.vueapi.service;

import com.github.pagehelper.PageInfo;
import com.liyan.vueapi.pojo.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User Login(String username, String password);

    PageInfo<User> findByPage(Integer pageCount, Integer pageSize, String username, String phone, String email) throws Exception;

    int addUser(String username, String password, String phone, String email) throws Exception;

    User findById(Integer id);

    int updateUser(Integer id, String phone, String email);

    int deleteByIdUser(Integer id);
}
