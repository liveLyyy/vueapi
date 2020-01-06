package com.liyan.vueapi.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liyan.vueapi.mapper.ArticleMapper;
import com.liyan.vueapi.pojo.Article;
import com.liyan.vueapi.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public PageInfo<Article> findArticle(Integer pageCount, Integer pageSize, String title, String desc, Date createTime,String username,String cname) throws Exception {
        PageHelper.startPage(pageCount,pageSize);
        Map<String,Object> map=new HashMap<>();
        map.put("title",title);
        map.put("desc",desc);
        map.put("createTime",createTime);
        List<Article> list=articleMapper.findArticle(map);
        PageInfo<Article> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int addArticle(Integer uid, Integer cid, String title, String desc, String content, Integer isTop,Date createTime)throws Exception {
        Article article=new Article(uid,cid,title,desc,content,isTop,createTime);
        return articleMapper.inseerArticle(article);
    }
}
