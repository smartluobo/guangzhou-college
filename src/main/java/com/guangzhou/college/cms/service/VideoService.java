package com.guangzhou.college.cms.service;

import com.guangzhou.college.dao.VideoMapper;
import com.guangzhou.college.entity.Video;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class VideoService {


    @Resource
    private VideoMapper videoMapper;

    public List<Video> queryVideoList(Video Video){
        return  videoMapper.queryVideoList(Video);
    }

    public int addVideo(Video Video){
        return videoMapper.addVideo(Video);
    }

    public int eidtVideo(Video Video){
        return  videoMapper.eidtVideo(Video);
    }

    public int delVideo(Integer id){
        return videoMapper.delVideo(id);
    }

}
