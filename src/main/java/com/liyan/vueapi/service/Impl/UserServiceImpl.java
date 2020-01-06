package com.liyan.vueapi.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liyan.vueapi.mapper.UserMapper;
import com.liyan.vueapi.pojo.User;
import com.liyan.vueapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User Login(String username, String password) {
        return userMapper.Login(username,password);
    }

    @Override
    public PageInfo<User> findByPage(Integer pageCount, Integer pageSize, String username, String phone, String email) throws Exception {
        PageHelper.startPage(pageCount, pageSize);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("username", username);
        map.put("phone", phone);
        map.put("emali", email);
        List<User> list = userMapper.findUser(map);
        PageInfo<User> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int addUser(String username, String password, String phone, String email) throws Exception {
        User user = new User(username, password, phone, email);
        return userMapper.insertUser(user);
    }

    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);
    }

    @Override
    public int updateUser(Integer id, String phone, String email) {
        User user = new User();
        user.setId(id);
        user.setPhone(phone);
        user.setEmail(email);
        return userMapper.updateUser(user);
    }

    @Override
    public int deleteByIdUser(Integer id) {
        return userMapper.deleteByIdUser(id);
    }
}
