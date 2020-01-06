package com.liyan.vueapi.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liyan.vueapi.mapper.CategoryMapper;
import com.liyan.vueapi.pojo.Category;
import com.liyan.vueapi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public PageInfo<Category> findByCatetoryAll(Integer pageCount, Integer pageSize, String cname) throws Exception {
        PageHelper.startPage(pageCount,pageSize);
        List<Category> list=categoryMapper.findByCatetoryAll(cname);
        PageInfo<Category> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int addCategory(String cname, Date createTime, Integer sort) throws Exception{
        int index=categoryMapper.insertCatetory(cname,createTime,sort);
        return index;
    }

    @Override
    public Category findByIdCategory(Integer cid) {
        return categoryMapper.findByIdCategory(cid);
    }

    @Override
    public int updateByIdCategory(Integer cid,String cname,Integer sort) {
        Category category=new Category();
        category.setCid(cid);
        category.setCname(cname);
        category.setSort(sort);
        return categoryMapper.updateByIdCategory(category);
    }

    @Override
    public int deleteByIdCategory(Integer cid) {
        return categoryMapper.deleteByIdCategory(cid);
    }

    @Override
    public List<Category> findAllCatetory() throws Exception {
        return categoryMapper.findAllCatetory();
    }
}
