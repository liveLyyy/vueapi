package com.liyan.vueapi.service;

import com.github.pagehelper.PageInfo;
import com.liyan.vueapi.pojo.Category;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface CategoryService {

    PageInfo<Category> findByCatetoryAll(Integer pageCount, Integer pageSize, String cname) throws Exception;

    int addCategory(String cname, Date createTime,Integer sort) throws  Exception;

    Category findByIdCategory(Integer cid);

    int updateByIdCategory(Integer cid,String cname,Integer sort);

    int deleteByIdCategory(Integer cid);

    List<Category> findAllCatetory() throws Exception;
}
