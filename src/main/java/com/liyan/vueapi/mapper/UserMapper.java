package com.liyan.vueapi.mapper;

import com.liyan.vueapi.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface UserMapper {

    User Login(@Param("username") String username, @Param("password") String password);

    List<User> findUser(Map<String, Object> map) throws Exception;

    int insertUser(@Param(value = "user") User user) throws Exception;

    User findById(Integer id);

    int updateUser(@Param(value = "user") User user);

    int deleteByIdUser(Integer id);
}
