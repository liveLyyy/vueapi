package com.liyan.vueapi.controller;

import com.github.pagehelper.PageInfo;
import com.liyan.vueapi.enums.ResultCode;
import com.liyan.vueapi.pojo.Category;
import com.liyan.vueapi.result.Result;
import com.liyan.vueapi.service.Impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryServiceImpl catetoryService;

    /*
    分类模糊查询
     */
    @GetMapping("/sys/catetory")
    public Result findAll(Integer pageCount, Integer pageSize, HttpServletRequest request) throws Exception{
        PageInfo<Category> pageInfo=catetoryService.findByCatetoryAll(pageCount,pageSize,request.getParameter("cname"));
        if (pageInfo != null){
            return Result.success(pageInfo);
        }
        return Result.failure(ResultCode.FAILURE);
    }

    /*
    添加分类信息
     */
    @PostMapping("/sys/catetory")
    public Result addCategory(@RequestBody Category category)throws Exception{
        String cname=category.getCname();
        Integer sort=category.getSort();
        int index=catetoryService.addCategory(cname,new Date(),sort);
        if (index != 0){
            return Result.success();
        }
        return Result.failure(ResultCode.FAILURE);
    }

    /*
    根据ID查找分类信息
     */
    @GetMapping("/sys/catetory/{cid}")
    public Result findByIdCategory(@PathVariable Integer cid){
        Category category=catetoryService.findByIdCategory(cid);
        if (null != category){
            return Result.success(category);
        }
        return Result.failure(ResultCode.FAILURE);
    }

    /*
    根据ID更新分类信息
     */
    @PutMapping("/sys/catetory/{cid}")
    public Result updateByIdCategory(@RequestBody Category category,@PathVariable Integer cid){
        int index=catetoryService.updateByIdCategory(cid,category.getCname(),category.getSort());
        if (0 != index){
            return Result.success(index);
        }
        return Result.failure(ResultCode.FAILURE);
    }

    /*
    根据ID删除分类信息
     */
    @DeleteMapping("/sys/catetory/{cid}")
    public Result deleteCategory(@PathVariable Integer cid){
        int index=catetoryService.deleteByIdCategory(cid);
        if (0 != index){
            return Result.success(index);
        }
        return Result.failure(ResultCode.FAILURE);
    }

    /*
    获取所有分类信息
     */
    @GetMapping("/sys/catetoryall")
    public Result findAllCategory() throws Exception{
        List<Category> list=catetoryService.findAllCatetory();
        if (null != list){
            return Result.success(list);
        }
        return Result.failure(ResultCode.FAILURE);
    }
}
