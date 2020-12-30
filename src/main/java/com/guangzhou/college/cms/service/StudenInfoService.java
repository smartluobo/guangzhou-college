package com.guangzhou.college.cms.service;

import com.guangzhou.college.dao.StudenInfoMapper;
import com.guangzhou.college.entity.StudenInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudenInfoService {


    @Resource
    private StudenInfoMapper StudenInfoMapper;

    public int deleteByPrimaryKey(Integer id) {
        return StudenInfoMapper.deleteByPrimaryKey(id);
    }

    public int insertSelective(StudenInfo record) {
        return StudenInfoMapper.insertSelective(record);
    }

    public StudenInfo selectByPrimaryKey(Integer id) {
        return StudenInfoMapper.selectByPrimaryKey(id);
    }

    public List<StudenInfo> selectListByPrimaryKey(StudenInfo record) {
        return StudenInfoMapper.selectListByPrimaryKey(record);
    }

    public int updateByPrimaryKeySelective(StudenInfo record) {
        return StudenInfoMapper.updateByPrimaryKeySelective(record);
    }


}
