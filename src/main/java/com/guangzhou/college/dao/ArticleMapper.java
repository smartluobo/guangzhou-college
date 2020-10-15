package com.guangzhou.college.dao;

import com.guangzhou.college.entity.TbApiUser;
import com.guangzhou.college.entity.Article;

import java.util.List;

public interface ArticleMapper {


    List<Article> queryArticleList(Article Article);

    int addArticle(Article Article);

    int eidtArticle(Article Article);

    int delArticle(Integer id);
}
