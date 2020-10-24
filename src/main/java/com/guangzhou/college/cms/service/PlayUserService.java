package com.guangzhou.college.cms.service;

import com.guangzhou.college.dao.PlayUserMapper;
import com.guangzhou.college.entity.PlayUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class PlayUserService {


    @Resource
    private PlayUserMapper playUserMapper;

    public List<PlayUser> queryPlayUserList(PlayUser PlayUser){
        return  playUserMapper.queryPlayUserList(PlayUser);
    }

    public int addPlayUser(PlayUser PlayUser){
        return playUserMapper.addPlayUser(PlayUser);
    }

    public int eidtPlayUser(PlayUser PlayUser){
        return  playUserMapper.eidtPlayUser(PlayUser);
    }

    public int delPlayUser(Integer id){
        return playUserMapper.delPlayUser(id);
    }

}
