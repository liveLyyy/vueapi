package com.liyan.vueapi.service;

import com.github.pagehelper.PageInfo;
import com.liyan.vueapi.pojo.Article;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Repository
public interface ArticleService {

    PageInfo<Article> findArticle(Integer pageCount, Integer pageSize, String title, String desc, Date createTime,String username,String cname) throws Exception;

    int addArticle(Integer uid,Integer cid,String title, String desc, String content,Integer isTop,Date createTime)throws Exception;
}
