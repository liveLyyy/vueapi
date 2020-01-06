package com.liyan.vueapi.mapper;

import com.liyan.vueapi.pojo.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface ArticleMapper {

   List<Article> findArticle(Map<String, Object> map) throws Exception;

   int inseerArticle(@Param("article") Article article)throws Exception;
}
