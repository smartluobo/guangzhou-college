package com.guangzhou.college.cms.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guangzhou.college.cms.service.PdfFileService;
import com.guangzhou.college.common.ResultInfo;
import com.guangzhou.college.common.ReturnCodeEnum;
import com.guangzhou.college.entity.PdfFile;
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
@RequestMapping("/cms/pdfFile")
public class PdfFileController {

    @Autowired
    private PdfFileService pdfFileService;

    /**
     * 根据条件查询菜单列表
     * @param request
     * @return ResultInfo
     */
    @PostMapping(value = "/queryPdfFileList")
    public ResultInfo queryPdfFileList(HttpServletRequest request,@RequestBody Map<String,Object> params) {
        ResultInfo resultInfo = new ResultInfo();
        PdfFile PdfFile = new PdfFile();
        PageHelper.startPage(Integer.valueOf(String.valueOf(params.get("pageNum"))),Integer.valueOf(String.valueOf(params.get("pageSize"))));
        List<PdfFile> list = pdfFileService.queryPdfFileList(PdfFile);
        PageInfo pageInfo = new PageInfo(list);
        resultInfo.setCode(ReturnCodeEnum.REQUEST_SUCCESS.getStatus());
        resultInfo.setTotal(pageInfo.getTotal());
        resultInfo.setData(list);
        return resultInfo;
    }


    /**
     * 添加记录
     * @param PdfFile
     * @return ResultInfo
     */
    @PostMapping(value = "/addPdfFile")
    public ResultInfo addPdfFile(@RequestBody PdfFile PdfFile) {
        pdfFileService.addPdfFile(PdfFile);
        return new ResultInfo(ReturnCodeEnum.REQUEST_SUCCESS.getStatus());
    }


    /**
     * 修改记录
     * @param PdfFile
     * @return ResultInfo
     */
    @PostMapping(value = "/eidtPdfFile")
    public ResultInfo eidtPdfFile(@RequestBody PdfFile PdfFile) {
        pdfFileService.eidtPdfFile(PdfFile);
        return new ResultInfo(ReturnCodeEnum.REQUEST_SUCCESS.getStatus());
    }



    /**
     * 单笔删除记录
     * @param pdfFile
     * @return ResultInfo
     */
    @PostMapping(value = "/delPdfFile")
    public ResultInfo delPdfFile(@RequestBody PdfFile pdfFile) {
        pdfFileService.delPdfFile(pdfFile.getId());
        return new ResultInfo(ReturnCodeEnum.REQUEST_SUCCESS.getStatus());
    }



}
