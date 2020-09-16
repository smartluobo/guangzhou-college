package com.guangzhou.college.common;

import com.guangzhou.college.common.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
@Slf4j
public class CommonService {

    @Value("${imagePath}")
    private String imagePathConfig;

    @Value("${imageUrlPrefix}")
    private String imageUrlPrefixConfig;


    public String imageUpload(MultipartFile file){
        if (file.isEmpty()){
            return null;
        }
        long currentTime = System.currentTimeMillis();
        String fileName = file.getOriginalFilename();  // 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        String dateYyyyMMdd = DateUtil.getDateYyyyMMdd();
        fileName = currentTime+suffixName; // 新文件名
        String imagePath = imagePathConfig + dateYyyyMMdd + File.separator + fileName;
        log.info("imagePath : {}",imagePath);
        File dest = new File(imagePathConfig + dateYyyyMMdd+File.separator+ fileName);
        if (!dest.getParentFile().exists()) {
            boolean mkdirs = dest.getParentFile().mkdirs();
            if (!mkdirs){
                return null;
            }
            log.info("parent file mkdirs success.....");
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            log.info("file upload fail ....");
        }
        String filename = imageUrlPrefixConfig + dateYyyyMMdd+"/" + fileName;
        return filename;
    }
}
