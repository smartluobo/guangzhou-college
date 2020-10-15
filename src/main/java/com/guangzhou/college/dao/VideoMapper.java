package com.guangzhou.college.dao;

import com.guangzhou.college.entity.TbApiUser;
import com.guangzhou.college.entity.Video;

import java.util.List;

public interface VideoMapper {

    void insert(TbApiUser user);

    List<Video> queryVideoList(Video Video);

    int addVideo(Video Video);

    int eidtVideo(Video Video);

    int delVideo(Integer id);
}
