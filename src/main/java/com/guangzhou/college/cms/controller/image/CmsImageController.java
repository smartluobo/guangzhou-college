package com.guangzhou.college.cms.controller.image;

import com.guangzhou.college.common.CommonService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping("upload/image")
public class CmsImageController {

    @Resource
    private CommonService commonService;

    @PostMapping("upload")
    public String imageUpload(@RequestParam(value = "file") MultipartFile file){
        return commonService.imageUpload(file);
    }
}
