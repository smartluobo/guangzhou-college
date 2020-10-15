package com.guangzhou.college.cms.service;

import com.guangzhou.college.dao.ArticleMapper;
import com.guangzhou.college.entity.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class ArticleService {


    @Resource
    private ArticleMapper articleMapper;

    public List<Article> queryArticleList(Article Article){
        return  articleMapper.queryArticleList(Article);
    }

    public int addArticle(Article Article){
        return articleMapper.addArticle(Article);
    }

    public int eidtArticle(Article Article){
        return  articleMapper.eidtArticle(Article);
    }

    public int delArticle(Integer id){
        return articleMapper.delArticle(id);
    }

}
