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
import java.text.SimpleDateFormat;
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

    /*
    文章信息模糊查询
     */
    @GetMapping("/sys/article")
    public Result getAll(Integer pageCount, Integer pageSize, Article article) throws Exception {
        PageInfo<Article> pageInfo = articleService.findArticle(pageCount, pageSize, article.getTitle(), article.getDescs(), article.getCreateTime(), article.getUser().getUsername(), article.getCategory().getCname());
        if (null != pageInfo) {
            return Result.success(pageInfo);
        }
        return Result.failure(ResultCode.FAILURE);
    }

    /*
    添加文章信息
     */
    @PostMapping("/sys/article")
    public Result addArticle(@Validated @RequestBody Article article, HttpServletRequest request) throws Exception {
       String user=redisUtils.get("loginUser");
       int uid=Integer.parseInt(user);
       int index=articleService.addArticle(uid,article.getcId(),article.getTitle(),article.getDescs(),article.getContent(),article.getIsTop(),new Date());
       System.out.println(article.getcId());
       if (0 != index){
           return Result.success(ResultCode.SUCCESS,"发布文章成功");
       }
       return  Result.failure(ResultCode.FAILURE,"发布文章失败");
    }

    /*
    根据ID查找文章信息
     */
    @GetMapping("/sys/article/{aId}")
    public Result findByIdArticle(@PathVariable Integer aId) throws Exception {
        Article article=articleService.findByIdArticle(aId);
        if (null != article){
            return Result.success(article);
        }
        return Result.failure(ResultCode.FAILURE,"根据ID查询文章失败");
    }

    /*
    根据ID删除文章信息
     */
    @DeleteMapping("/sys/article/{aId}")
    public Result deleteByIdArticle(@PathVariable Integer aId)throws Exception{
        int index=articleService.deleteByIdArticle(aId);
        if (0 != index){
            return Result.success(ResultCode.SUCCESS);
        }
        return Result.failure(ResultCode.FAILURE,"根据ID删除文章失败");
    }

    /*
    根据Id修改文章
     */

    @PutMapping("/sys/article/{aId}")
    public Result updateArticle( @RequestBody Article article,@PathVariable Integer aId) throws Exception{
        int cId=article.getcId();
        String title=article.getTitle();
        String desc=article.getDescs();
        String content=article.getContent();
        Integer isTop=article.getIsTop();
        Date datetime=new Date();
        int index=articleService.updateArticle(aId,cId,title,desc,content,isTop,datetime);
        if (index != 0){
            return Result.success(index);
        }
        return Result.failure(ResultCode.FAILURE);
    }

}
