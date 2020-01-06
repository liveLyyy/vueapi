package com.liyan.vueapi.mapper;

import com.liyan.vueapi.pojo.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RoleMapper {

    List<Role> findById(Integer id);

    List<Role> findAll();
}
