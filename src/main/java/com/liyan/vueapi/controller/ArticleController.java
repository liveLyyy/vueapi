package com.liyan.vueapi.controller;

import com.alibaba.druid.wall.WallSQLException;
import com.github.pagehelper.PageInfo;
import com.liyan.vueapi.enums.ResultCode;
import com.liyan.vueapi.pojo.Article;
import com.liyan.vueapi.pojo.User;
import com.liyan.vueapi.result.Result;
import com.liyan.vueapi.service.Impl.ArticleServiceImpl;
import com.liyan.vueapi.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ArticleController {

    @Autowired
    ArticleServiceImpl articleService;
    @Autowired
    private RedisUtils redisUtils;

    @GetMapping("/sys/getArticle")
    public Result getAll(Integer pageCount, Integer pageSize, Article article) throws Exception {
        PageInfo<Article> pageInfo = articleService.findArticle(pageCount, pageSize, article.getTitle(), article.getDesc(), article.getCreateTime(), article.getUser().getUsername(), article.getCategory().getCname());
        if (null != pageInfo) {
            return Result.success(pageInfo);
        }
        return Result.failure(ResultCode.FAILURE);
    }

    @PostMapping("/sys/addArticle")
    public Result addArticle(@Validated @RequestBody Article article, HttpServletRequest request) throws Exception {
       String user=redisUtils.get("loginUser");
       int uid=Integer.parseInt(user);
       int index=articleService.addArticle(uid,article.getcId(),article.getTitle(),article.getDesc(),article.getContent(),article.getIsTop(),new Date());
       System.out.println(article.getcId());
       if (0 != index){
           return Result.success(ResultCode.SUCCESS,"发布文章成功");
       }
       return  Result.failure(ResultCode.FAILURE,"发布文章失败");
    }

    @GetMapping("/sys/findByIdArticle/{aId}")
    public Result findByIdArticle(@PathVariable Integer aId) throws Exception {
        Article article=articleService.findByIdArticle(aId);
        if (null != article){
            return Result.success(article);
        }
        return Result.failure(ResultCode.FAILURE,"根据ID查询文章失败");
    }

    @DeleteMapping("/sys/deleteByIdArticle/{aId}")
    public Result deleteByIdArticle(@PathVariable Integer aId)throws Exception{
        int index=articleService.deleteByIdArticle(aId);
        if (0 != index){
            return Result.success(ResultCode.SUCCESS);
        }
        return Result.failure(ResultCode.FAILURE,"根据ID删除文章失败");
    }


}
