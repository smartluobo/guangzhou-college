package com.guangzhou.college.dao;

import com.guangzhou.college.entity.PdfFile;

import java.util.List;

public interface PdfFileMapper {

    List<PdfFile> queryPdfFileList(PdfFile PdfFile);

    int addPdfFile(PdfFile PdfFile);

    int eidtPdfFile(PdfFile PdfFile);

    int delPdfFile(Integer id);
}
