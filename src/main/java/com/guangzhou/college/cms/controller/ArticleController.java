package com.guangzhou.college.cms.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guangzhou.college.cms.service.ArticleService;
import com.guangzhou.college.common.ResultInfo;
import com.guangzhou.college.common.ReturnCodeEnum;
import com.guangzhou.college.entity.Article;
import com.guangzhou.college.entity.Title;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 用户Controller
 */
@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/cms/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 根据条件查询菜单列表
     * @param request
     * @return ResultInfo
     */
    @PostMapping(value = "/queryArticleList")
    public ResultInfo queryArticleList(HttpServletRequest request, @RequestBody Map<String,Object> params) {
        ResultInfo resultInfo = new ResultInfo();
        Article Article = new Article();
        PageHelper.startPage(Integer.valueOf(String.valueOf(params.get("pageNum"))),Integer.valueOf(String.valueOf(params.get("pageSize"))));
        List<Article> list = articleService.queryArticleList(Article);
        PageInfo pageInfo = new PageInfo(list);
        resultInfo.setCode(ReturnCodeEnum.REQUEST_SUCCESS.getStatus());
        resultInfo.setTotal(pageInfo.getTotal());
        resultInfo.setData(list);
        return resultInfo;
    }


    /**
     * 添加记录
     * @param Article
     * @return ResultInfo
     */
    @PostMapping(value = "/addArticle")
    public ResultInfo addArticle(@RequestBody Article Article) {
        articleService.addArticle(Article);
        return new ResultInfo(ReturnCodeEnum.REQUEST_SUCCESS.getStatus());
    }


    /**
     * 修改记录
     * @param Article
     * @return ResultInfo
     */
    @PostMapping(value = "/eidtArticle")
    public ResultInfo eidtArticle(@RequestBody Article Article) {
        articleService.eidtArticle(Article);
        return new ResultInfo(ReturnCodeEnum.REQUEST_SUCCESS.getStatus());
    }



    /**
     * 单笔删除记录
     * @param article
     * @return ResultInfo
     */
    @PostMapping(value = "/delArticle")
    public ResultInfo delArticle(@RequestBody Article article) {
        articleService.delArticle(article.getId());
        return new ResultInfo(ReturnCodeEnum.REQUEST_SUCCESS.getStatus());
    }


}
