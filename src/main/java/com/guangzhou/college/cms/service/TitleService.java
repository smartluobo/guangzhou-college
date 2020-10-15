package com.guangzhou.college.cms.service;

import com.guangzhou.college.dao.TitleMapper;
import com.guangzhou.college.entity.Title;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class TitleService {


    @Resource
    private TitleMapper titleMapper;

    public List<Title> queryTitleList(Title title){
        return  titleMapper.queryTitleList(title);
    }

    public int addTitle(Title title){
        return titleMapper.addTitle(title);
    }

    public int eidtTitle(Title title){
        return  titleMapper.eidtTitle(title);
    }

    public int delTitle(Integer id){
        return titleMapper.delTitle(id);
    }


}
