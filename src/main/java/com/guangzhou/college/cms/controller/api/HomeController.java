package com.guangzhou.college.cms.controller.api;

import com.guangzhou.college.cms.service.*;
import com.guangzhou.college.entity.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/home")
public class HomeController {



    @Autowired
    private VideoService videoService;

    @Autowired
    private TitleService titleService;


    @Autowired
    private GlobalService globalService;


    @Autowired
    private ArticleService articleService;


    @Autowired
    private PdfFileService pdfFileService;
    /**
     * 添加记录
     * @param params
     * @return ResultInfo
     */
    @PostMapping(value = "/homeData")
    public Map<String,Object> homeData(@RequestBody Map<String,Object> params){
        Map<String,Object> result = new HashMap<>();

        List<Title> menuList = titleService.queryTitleList(new Title());
        List<Global> globalObject = globalService.queryGlobalList(new Global());
        List<Article> articleList =  articleService.queryArticleList(new Article());
        List<PdfFile> pdfFileList =  pdfFileService.queryPdfFileList(new PdfFile());
        List<Video> videoList = videoService.queryVideoList(new Video());
        result.put("middleVideoList",videoList);
        result.put("menuList",menuList);
        result.put("articleList",articleList);
        result.put("pdfFileList",pdfFileList);
        result.put("globalObject",globalObject.get(0));
        return result;
    }



}
