package com.guangzhou.college.cms.service;

import com.guangzhou.college.dao.PdfFileMapper;
import com.guangzhou.college.entity.PdfFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class PdfFileService {


    @Resource
    private PdfFileMapper pdfFileMapper;

    public List<PdfFile> queryPdfFileList(PdfFile PdfFile){
        return  pdfFileMapper.queryPdfFileList(PdfFile);
    }

    public int addPdfFile(PdfFile PdfFile){
        return pdfFileMapper.addPdfFile(PdfFile);
    }

    public int eidtPdfFile(PdfFile PdfFile){
        return  pdfFileMapper.eidtPdfFile(PdfFile);
    }

    public int delPdfFile(Integer id){
        return pdfFileMapper.delPdfFile(id);
    }

}
