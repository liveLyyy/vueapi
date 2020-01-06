package com.liyan.vueapi.mapper;

import com.liyan.vueapi.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface CategoryMapper {

    List<Category> findByCatetoryAll(String cname) throws Exception;

    int insertCatetory(String cname, Date createTime, Integer sort) throws Exception;

    Category findByIdCategory(Integer cid);

    int updateByIdCategory(@Param(value = "category") Category category);

    int deleteByIdCategory(Integer cid);

    List<Category> findAllCatetory() throws Exception;
}
