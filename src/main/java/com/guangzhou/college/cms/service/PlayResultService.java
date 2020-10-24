package com.guangzhou.college.cms.service;

import com.guangzhou.college.dao.PlayResultMapper;
import com.guangzhou.college.entity.PlayResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class PlayResultService {


    @Resource
    private PlayResultMapper playResultMapper;

    public List<PlayResult> queryPlayResultList(PlayResult PlayResult){
        return  playResultMapper.queryPlayResultList(PlayResult);
    }

    public int addPlayResult(PlayResult PlayResult){
        return playResultMapper.addPlayResult(PlayResult);
    }

    public int eidtPlayResult(PlayResult PlayResult){
        return  playResultMapper.eidtPlayResult(PlayResult);
    }

    public int delPlayResult(Integer id){
        return playResultMapper.delPlayResult(id);
    }

}
